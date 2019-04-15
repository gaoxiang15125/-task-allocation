package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.ProductNameEntity;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 14:31
 * @email: 630268696@qq.com
 **/
public interface ProductNameMapper {
    int addProductName(ProductNameEntity productNameEntity);
    int deleteProductNameById(int productNameId);
    int updateProductNameById(ProductNameEntity productNameEntity);
    ProductNameEntity getProductNameByProductNameId(int productNameId);
    int isProductNameExist(String productName);
}
