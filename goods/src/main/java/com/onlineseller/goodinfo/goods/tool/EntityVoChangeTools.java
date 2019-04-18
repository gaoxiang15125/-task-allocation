package com.onlineseller.goodinfo.goods.tool;

import com.onlineseller.goodinfo.goods.entity.ProductValueEntity;
import com.onlineseller.goodinfo.goods.vo.GoodsVo;
import com.onlineseller.goodinfo.goods.vo.StandardVo;

/**
 * @program: demo
 * @Description: 该类主要负责实现一些Entity与vo转化的方法
 * @author: Mr.gao
 * @create: 2019-04-18 10:14
 * @email: 630268696@qq.com
 **/
public class EntityVoChangeTools {

    /**
     * @param standardVo 存储型号信息的实体类
     * @param goodsId 型号对应的商品ID
     * @param productNameId 商品型号名称对应在表中ID地址
     * @return
     */
    public static ProductValueEntity changeStandardVoToProductValueEntity(StandardVo standardVo,int goodsId,int productNameId){
        return new ProductValueEntity(goodsId,standardVo.getStandardName(),productNameId,standardVo.getMoneyChange(),standardVo.getPicUrl());
    }

    /**
     * @param productValueEntity
     * @param standardName 对应的型号属性名称
     * @return
     */
    public static StandardVo changeProductValueEntitToStandardVo(ProductValueEntity productValueEntity,String standardName){
        return new StandardVo(standardName,productValueEntity.getProductName(),productValueEntity.getMoneyChange(),productValueEntity.getPicUrl());
    }
}
