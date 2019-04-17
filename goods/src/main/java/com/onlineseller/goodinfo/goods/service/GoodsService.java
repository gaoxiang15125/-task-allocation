package com.onlineseller.goodinfo.goods.service;

import com.onlineseller.goodinfo.goods.entity.BrandsEntity;
import com.onlineseller.goodinfo.goods.entity.CategoriesEntity;
import com.onlineseller.goodinfo.goods.entity.SpuEntity;
import com.onlineseller.goodinfo.goods.mapper.*;
import com.onlineseller.goodinfo.goods.vo.GoodsVo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.AttrDecls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        int classifyID = addClassIfies(goodsVo.getClassifies());
        //存储spuEntity，添加商品
        SpuEntity spuEntity = new SpuEntity(goodsVo.getDescription(),goodsVo.getPicUrls(),goodsVo.getGoodScore(),brandsEntity.getBrandId(),goodsVo.getSellerId(),classifyID,goodsVo.getGoodsName(),goodsVo.getPrice());

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
    private int addClassIfies(List<String> classifies){
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
}
