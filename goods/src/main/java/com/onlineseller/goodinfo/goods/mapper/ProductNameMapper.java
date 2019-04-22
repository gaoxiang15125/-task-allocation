package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.ProductNameEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 14:31
 * @email: 630268696@qq.com
 **/
@Mapper
@Repository
public interface ProductNameMapper {
    int addProductName(ProductNameEntity productNameEntity);
    int deleteProductNameById(int productNameId);
    int updateProductNameById(ProductNameEntity productNameEntity);
    ProductNameEntity getProductNameByProductNameId(int productNameId);
    String getNameByProductNameId(int productNameId);
    //获取对应属性的ID
    int getProductNameIDByProductName(String productName);
    int isProductNameExist(String productName);

}
