package com.crawler.seller.taobao.pagecrawler;

import com.crawler.seller.taobao.dao.*;
import com.crawler.seller.taobao.entity.*;
import com.crawler.seller.taobao.tools.HttpTools;
import com.crawler.seller.taobao.tools.RandomTools;
import com.crawler.seller.taobao.tools.StaticInfoTools;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: taobao
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-23 10:05
 * @email: 630268696@qq.com
 **/
@RestController
public class GoodsPageCrawler {

    public static HttpTools httpTools = HttpTools.getInstrance();

    @Autowired
    AttributeNameDao attributeNameDao;
    @Autowired
    AttributeValueDao attributeValueDao;
    @Autowired
    BrandsDao brandsDao;
    @Autowired
    CategoriesDao categoriesDao;
    @Autowired
    ProductNameDao productNameDao;
    @Autowired
    ProductValueDao productValueDao;
    @Autowired
    SkuDao skuDao;
    @Autowired
    SpuDao spuDao;
    /**
     * @param document 包含图片资源的网页文本对象
     * @return 仅仅包含Url标签的标签组
     */
    public static Elements picUrlFinder(Document document){
        Elements elements = document.select("img[src]");
        return elements;
    }
    /**
     * @param picMainUrl 照片Url
     * @return 包含图片Url的List对象
     */
    public static List<String> getPicUrlForGoods(String picMainUrl){
        Document document = httpTools.getDocumentByJSoupGet(picMainUrl);
        Elements elements = GoodsPageCrawler.picUrlFinder(document);
        List<String> picUrl = new ArrayList<>();
        for(int i=0;i<elements.size();i++){
            String tag = elements.get(i).attr("class");
            if(tag.equals("desc_anchor")){
                continue;
            }
            picUrl.add(elements.get(i).attr("src"));
        }
        return picUrl;
    }
    /**
     * @return 待定
     */
    @PostMapping("/crawler")
    public String getGoodsInfo(String goodsUrl){
        //String goodsUrl="https://item.taobao.com/item.htm?spm=2013.1.20160405.7.7bfe2f40N3ZjKp&scm=1007.13066.127283.0&id=43333939583";
        Document document = httpTools.getDocumentByJSoupGet(goodsUrl);
        String goodsName = document.getElementsByClass("tb-main-title").text();
        double[] moneyRange = getGoodsPrice(document);
        double moneyPlus;
        if(moneyRange.length==2){
            moneyPlus = moneyRange[1]-moneyRange[0];
        }else{
            moneyPlus = moneyRange[0];
        }

        //至此，可以通过Map获取JavaScript中配置信息，构造Url后即可获取商品
        Map<String,String> jsonMapForInfo = getConfigInfo(document);
        //构造目标Url
        String picUrl = jsonMapForInfo.get("descUrl");
        //Url地址
        List<String> picUrls = getPicUrlForGoods(HttpTools.httpTag+picUrl);
        StringBuilder stringBuilder = new StringBuilder();
        for(String string:picUrls){
            stringBuilder.append(string+HttpTools.picLinkTag);
        }
        Map<String,String> goodsMap = getGoodsInfo(document);
        BrandsEntity brandsEntity = null;
        CategoriesEntity categoriesEntity;
        if(goodsMap.containsKey(StaticInfoTools.brand)){
            String brandName = goodsMap.get(StaticInfoTools.brand);
            goodsMap.remove(StaticInfoTools.brand);
            if(brandsDao.existsByBrandName(brandName)){
                brandsEntity = brandsDao.findBrandsEntityByBrandName(brandName);
            }else{
                brandsEntity = brandsDao.save(new BrandsEntity(brandName,""));
            }
        }
        if(categoriesDao.existsByClassifyName(classifyInfo)){
            categoriesEntity = categoriesDao.findCategoriesEntityByClassifyName(classifyInfo);
        }else{
            categoriesEntity = categoriesDao.save(new CategoriesEntity(classifyInfo,-1));
        }
        if(brandsEntity==null){
            System.out.println("未获得品牌信息");
            brandsEntity = brandsDao.getOne(0);
        }
        //存储商品基本信息
        SpuEntity spuEntity = new SpuEntity("本字段用图片代替", RandomTools.getRandom(10),brandsEntity.getBrandId(),sellerId,categoriesEntity.getClassifyId(),
                goodsName,stringBuilder.toString(),moneyRange[0],0);
        spuEntity = spuDao.save(spuEntity);
        //存储属性信息与型号信息
        AttributeNameEntity attributeNameEntity = null;
        AttributeValueEntity attributeValueEntity =null;
        ProductNameEntity productNameEntity = null;
        ProductValueEntity productValueEntity = null;
        for(String key:goodsMap.keySet()){
            String value = goodsMap.get(key);
            String[] strNum = value.split(" ");
            if(strNum.length>1){
                //此值为型号
                double[] moneyChangeRange;
                if(moneyRange.length==2){
                    moneyChangeRange = RandomTools.getRandomPrice(moneyPlus,strNum.length);
                }else{
                    moneyChangeRange = RandomTools.getUnchangePrice(moneyPlus,strNum.length);
                }
                if(productNameDao.existsByProductName(key)){
                    productNameEntity = productNameDao.findProductNameEntityByProductName(key);
                }else{
                    productNameEntity = new ProductNameEntity(key);
                    productNameEntity = productNameDao.save(productNameEntity);
                }
                for(int i=0;i<strNum.length;i++){
                    productValueEntity = new ProductValueEntity(spuEntity.getGoodId(),strNum[i],productNameEntity.getProductNameId(),moneyChangeRange[i],null);
                    productValueDao.save(productValueEntity);
                }
            }else{
                //此值为属性值
                if(attributeNameDao.existsByQualityName(key)){
                    attributeNameEntity = attributeNameDao.findAttributeNameEntityByQualityName(key);
                }else{
                    attributeNameEntity = new AttributeNameEntity(key);
                    attributeNameEntity = attributeNameDao.save(attributeNameEntity);
                }
                attributeValueEntity = new AttributeValueEntity(attributeNameEntity.getQualityId(),value,spuEntity.getGoodId());
                attributeValueDao.save(attributeValueEntity);
            }
        }
        return "success";
    }

    public static double[] getGoodsPrice(Document document){
        Element element = document.getElementsByClass("tb-rmb-num").first();
        String[] moneyRange = element.text().split(" - ");
        double[] doubleRange = new double[moneyRange.length];
        for(int i=0;i<moneyRange.length;i++){
            doubleRange[i]=Double.parseDouble(moneyRange[i]);
        }
        return doubleRange;
    }
    /**
     * 获取商品网站中JavaScript 配置信息
     * @param document
     * @return
     */
    public static Map<String,String> getConfigInfo(Document document){
        Element elementScript = document.getElementsByTag("script").first();
        String g_configs = elementScript.data().split(";")[0];
        //根据config内容构造相应的Json
        g_configs = g_configs.substring(g_configs.indexOf("=")+1).trim();
        g_configs = g_configs.substring(1,g_configs.length()-1).trim();
        //System.out.println(g_configs);
        String[] infoConfigs = g_configs.split("\n");
        Map<String,String> jsonMapForInfo = new HashMap();
        for(String string:infoConfigs){
            String[] keyValue = string.split("   :");
            if(keyValue.length!=2){
                continue;
            }else if(keyValue[0].equals(" ")||keyValue[0]==null){
                continue;
            }
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            value = value.substring(0,value.length()-1);
            jsonMapForInfo.put(key,value);
            //System.out.println(key+"   "+value);
        }
        String picUrl = jsonMapForInfo.get("descUrl");
        //奇葩的分割,迁移到函数内，避免大规模的影响
        picUrl = picUrl.split(" ? ")[2];
        picUrl = picUrl.split(" : ")[0];
        picUrl = picUrl.substring(1,picUrl.length()-1);
        jsonMapForInfo.replace("descUrl",picUrl);
        return jsonMapForInfo;
    }

    public static Map<String,String> getGoodsInfo(Document document){
        Elements elements = document.getElementsByClass("attributes-list").first().children();
        //商品的信息存储到了 goodsMap中，以键值对的形式进行存储
        Map<String,String> goodsMap = new HashMap<>();
        for(Element element:elements){
            String value = element.attr("title");
            if(value==null||value.equals("")){
                continue;
            }else{
                String name = element.text().split(":")[0];
                //System.out.println(element.text());
                System.out.println(name +"  :  "+value);
                goodsMap.put(name,value);
            }
        }
        return goodsMap;
    }

    public static String classifyInfo ="游戏外设";
    public static int sellerId=0;
    public static void main(String[]args){
        String goodsUrl="https://item.taobao.com/item.htm?spm=2013.1.20160405.7.7bfe2f40N3ZjKp&scm=1007.13066.127283.0&id=43333939583";
        System.out.println(httpTools.getDocumentByJSoupGet(goodsUrl));
        //getGoodsPrice(httpTools.getDocumentByJSoupGet(goodsUrl));
        //getGoodsInfo("https://item.taobao.com/item.htm?spm=a1z10.1-c.w5003-18657069090.1.7adc16ec3Dov1x&id=585174273980&scene=taobao_shop");
        //getGoodsInfo(goodsUrl);
    }
}
