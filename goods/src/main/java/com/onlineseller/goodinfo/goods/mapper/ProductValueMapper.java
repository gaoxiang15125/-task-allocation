package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.ProductValueEntity;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 14:29
 * @email: 630268696@qq.com
 **/
public interface ProductValueMapper {
    int addProductValue(ProductValueEntity productValueEntity);
    int deleteProductValueById(int id);
    int updateProductValueById(ProductValueEntity productValueEntity);
    List<ProductValueEntity> getProductValueByProductId(int productId);

}
