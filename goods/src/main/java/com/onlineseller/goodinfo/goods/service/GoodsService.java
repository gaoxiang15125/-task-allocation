package com.onlineseller.goodinfo.goods.service;

import com.onlineseller.goodinfo.goods.entity.*;
import com.onlineseller.goodinfo.goods.mapper.*;
import com.onlineseller.goodinfo.goods.tool.EntityVoChangeTools;
import com.onlineseller.goodinfo.goods.tool.GatherTools;
import com.onlineseller.goodinfo.goods.vo.GoodsVo;
import com.onlineseller.goodinfo.goods.vo.StandardVo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.AttrDecls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-16 11:48
 * @email: 630268696@qq.com
 **/
@Service
public class GoodsService {
    @Autowired
    AttributeValueMapper attributeValueMapper;
    @Autowired
    AttributeNameMapper attributeNameMapper;
    @Autowired
    BrandsMapper brandsMapper;
    @Autowired
    CategoriesMapper categoriesMapper;
    @Autowired
    ProductNameMapper productNameMapper;
    @Autowired
    ProductValueMapper productValueMapper;
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    SpuMapper spuMapper;

    /**
     * @return 添加GoodsVo的结果
     */
    public boolean addGoodsVo(GoodsVo goodsVo){
        //将商品的品牌信息绑定到数据库
        BrandsEntity brandsEntity;
        if(brandsMapper.isBrandNameExist(goodsVo.getBrand())==0){
            brandsEntity = new BrandsEntity(goodsVo.getBrand(),goodsVo.getBrandDescription());
            brandsMapper.addBrands(brandsEntity);
            brandsEntity.setBrandId(brandsMapper.getBrandIdByBrandName(goodsVo.getBrand()));
        } else{
            brandsEntity = brandsMapper.getBrandsByBrandName(goodsVo.getBrand());
        }
        //将商品的分类信息绑定到数据库 分类信息使用链表存储
        int classifyID = addClassifies(goodsVo.getClassifies());
        //存储spuEntity，添加商品
        SpuEntity spuEntity = new SpuEntity(goodsVo.getDescription(),GatherTools.ListToString(goodsVo.getPicUrls(),GatherTools.picUrlTag),goodsVo.getGoodScore(),brandsEntity.getBrandId(),goodsVo.getSellerId(),classifyID,goodsVo.getGoodsName(),goodsVo.getPrice());
        spuMapper.addSpu(spuEntity);
        //商品基本属性信息
        addAttributes(goodsVo.getAttributes(),goodsVo.getGoodId());
        addStandards(goodsVo.getStandards(),goodsVo.getGoodId());
        //至此商品所有信息存储完毕
        return true;
    }
    /**
     *
     * @param goodId 目标商品ID
     * @return 存储商品信息的实体类
     */
    public GoodsVo getGoodsVoById(int goodId){

    }

    public List<GoodsVo> getGoodsVoBySellerId(int sellerId){

    }

    public List<GoodsVo> getGoodsVoByClassifyId(int classifyId){

    }
    public List<GoodsVo> getAllGoods(){

    }
    public List<GoodsVo> getGoodsByLikeName(String likeWord){

    }

    /**
     * @param classifies 链表结构的分类列
     * @return
     */
    private int addClassifies(List<String> classifies){
        for(int i=0;i<classifies.size();i++){
            if(categoriesMapper.isClassifyNameExists(classifies.get(i))==0){
                if(i==0){
                    //使用-1标识根节点，保证表中的根节点可以被识别
                    categoriesMapper.addCategories(new CategoriesEntity(classifies.get(i),-1));
                }else{
                    CategoriesEntity categoriesEntity=categoriesMapper.getCategoriesByClassifyName(classifies.get(i-1));
                    categoriesMapper.addCategories(new CategoriesEntity(classifies.get(i),categoriesEntity.getClassifyId()));
                }
            }else {
                continue;
            }
        }
        return categoriesMapper.getCategoriesByClassifyName(classifies.get(classifies.size()-1)).getClassifyId();
    }

    private boolean addAttributes(Map<String,String> attributes,int goodsId){
        for (Map.Entry<String, String> entry : attributes.entrySet()){
            //System.out.println(entry.getKey() + ":" + entry.getValue());
            String key = entry.getKey();
            String value = entry.getValue();
            int qualityId;
            if(attributeNameMapper.isAttributeNameExists(key)==0){
                attributeNameMapper.addAttributeName(new AttributeNameEntity(key));
            }else{

            }
            qualityId =attributeNameMapper.getQualityIdByQualityName(key);
            AttributeValueEntity attributeValueEntity = new AttributeValueEntity(qualityId,value,goodsId);
            attributeValueMapper.addAttributeValue(attributeValueEntity);
        }
        //出现错误返回false，此处先不做该处理
        return true;
    }

    private boolean addStandards(Map<String,Map<String, StandardVo>> standards,int goodsId){
        for(Map.Entry<String,Map<String,StandardVo>>entry:standards.entrySet()){
            for(Map.Entry<String,StandardVo> standardEntry:entry.getValue().entrySet()){
                StandardVo standardVo = standardEntry.getValue();
                String standardName = standardEntry.getKey();
                if(productNameMapper.isProductNameExist(standardName)==0){
                    productNameMapper.addProductName(new ProductNameEntity(standardName));
                }else{

                }
                int productNameID = productNameMapper.getProductNameIDByProductName(standardName);
                productValueMapper.addProductValue(EntityVoChangeTools.changeStandardVoToProductValueEntity(standardVo,goodsId,productNameID));
            }
        }
        return true;
    }

    /**
     * 通过此方法将从数据库获取的spuEntity对象装载成goodsVo
     * @param spuEntity 与数据库中商品直接关联的实体类
     * @return 装载完成的GoodsVo对象
     */
    private GoodsVo getGoodsBySpuEntity(SpuEntity spuEntity){
        //根据属性顺序装在GoodsVo
        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setGoodId(spuEntity.getGoodId());
        goodsVo.setDescription(spuEntity.getDescription());
        goodsVo.setGoodScore(spuEntity.getGoodScore());
        BrandsEntity brandsEntity = brandsMapper.getBrandsByBrandId(spuEntity.getBrandId());
        goodsVo.setBrand(brandsEntity.getBrandName());
        goodsVo.setBrandDescription(brandsEntity.getDescription());
        //通过递归或者便利获取分类树结构
        goodsVo.setClassifies(getClassifiesList(spuEntity.getClassifyId()));
        goodsVo.setPicUrls(GatherTools.StringToList(spuEntity.getPicUrl(),GatherTools.picUrlTag));
        goodsVo.setGoodsName(spuEntity.getName());
        goodsVo.setSellerId(spuEntity.getSellerId());
        goodsVo.setPrice(spuEntity.getPrice());
        goodsVo.setStandards(getStandardsForGoodsVo(spuEntity.getGoodId()));

    }

    /**
     * @param classifyID 商品spu里存储的分类子节点
     * @return 由分类构成的链表结构
     */
    private List<String> getClassifiesList(int classifyID){
        CategoriesEntity categoriesEntity = categoriesMapper.getCategoriesByClassifyId(classifyID);
        List<CategoriesEntity> categories = new ArrayList<>();
        categories.add(categoriesEntity);
        while (true){
            if(categoriesEntity.getFatherId()>0){
                categoriesEntity = categoriesMapper.getCategoriesByClassifyId(categoriesEntity.getClassifyId());
                categories.add(categoriesEntity);
            }else {
                break;
            }
        }
        ArrayList<String> strings = new ArrayList<>();
        for(int i= categories.size()-1;i>=0;i--){
            strings.add(categories.get(i).getClassifyName());
        }
       return strings;
    }

    /**
     * 根据goodsID填充其对应的HashMap值
     * @param goodsID 需要装配的商品的键值
     * @return 型号的唯一区别码，用来计算价格，提示map中需要装载的信息在函数中已被装在到集合中,此处因为不会与型号相关所以不会传递此字段
     */
    private HashMap<String,Map<String,StandardVo>> getStandardsForGoodsVo(int goodsID){
        List<ProductValueEntity> productValueEntities = productValueMapper.getProductValueByGoodsId(goodsID);
        List<StandardVo> standardVos = new ArrayList<>();
        //存储属性与对应Id的map集合,缓存资源的map类,用来减少查询次数
        Map<Integer,String> standardId = new HashMap<>();
        int productNameID;
        String standardName;
        for(ProductValueEntity productValueEntity:productValueEntities){
            productNameID = productValueEntity.getProductNameId();
            if(standardId.containsKey(productNameID)){
                standardName = standardId.get(productNameID);
            }else{
                standardName = productNameMapper.getProductNameByProductNameId(productNameID).getProductName();
                standardId.put(productNameID,standardName);
            }
            StandardVo standardVo = EntityVoChangeTools.changeProductValueEntitToStandardVo(productValueEntity,standardName);
            standardVos.add(standardVo);
        }
        HashMap<String,Map<String,StandardVo>> stringMapMap = new HashMap<>();
        Map<String,StandardVo> stringStandardVoMap;
        String standardValue;
        for(StandardVo standardVo:standardVos){
            standardName = standardVo.getStandardName();
            standardValue = standardVo.getStandardValue();
            if(stringMapMap.containsKey(standardName)){
                stringStandardVoMap=stringMapMap.get(standardName);
                stringStandardVoMap.put(standardValue,standardVo);
            }else{
                stringStandardVoMap = new HashMap<>();
                stringStandardVoMap.put(standardValue,standardVo);
                stringMapMap.put(standardName,stringStandardVoMap);
            }
        }
        return stringMapMap;
    }
}
