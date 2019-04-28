package com.crawler.seller.taobao.pagecrawler;

import com.crawler.seller.taobao.tools.HttpTools;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
public class GoodsPageCrawler {

    public static HttpTools httpTools = HttpTools.getInstrance();

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
     * @param goodsUrl 目标商品url地址
     * @return 待定
     */
    public static String getGoodsInfo(String goodsUrl){
        Document document = httpTools.getDocumentByJSoupGet(goodsUrl);
        System.out.println(document.toString());
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
        //至此，可以通过Map获取JavaScript中配置信息，构造Url后即可获取商品
        //构造目标Url
        String picUrl = jsonMapForInfo.get("descUrl");
        //奇葩的分割
        picUrl = picUrl.split(" ? ")[2];
        picUrl = picUrl.split(" : ")[0];
        picUrl = picUrl.substring(1,picUrl.length()-1);
        //Url地址
        List<String> picUrls = getPicUrlForGoods(HttpTools.httpTag+picUrl);
        for(int i=0;i<picUrls.size();i++){
            System.out.println(picUrls.get(i));
        }
        //下面是获取商品自然信息
        Elements elements = document.getElementsByClass("attributes-list").first().children();
        //elements = elements.first().children();
        //System.out.println(elements);
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
            //System.out.println(element);
        }

        return null;
    }

    public static void getGoodsPrice(Document document){
        Elements elements = document.getElementsByClass("tb-rmb-num");
        for(Element element:elements){
            System.out.println("~~~~~~~~~~~~~~");
            System.out.println(element);
        }
        Element element = elements.first();
        System.out.println(element.text());
    }
    public static void main(String[]args){
        String goodsUrl="https://item.taobao.com/item.htm?spm=2013.1.20160405.7.7bfe2f40N3ZjKp&scm=1007.13066.127283.0&id=43333939583";
        getGoodsPrice(httpTools.getDocumentByJSoupGet(goodsUrl));
        //getGoodsInfo("https://item.taobao.com/item.htm?spm=a1z10.1-c.w5003-18657069090.1.7adc16ec3Dov1x&id=585174273980&scene=taobao_shop");
        //getGoodsInfo(goodsUrl);
    }
}
