package com.onlineseller.goodinfo.goods.service;

import com.onlineseller.goodinfo.goods.entity.ProductValueEntity;
import com.onlineseller.goodinfo.goods.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-22 10:22
 * @email: 630268696@qq.com
 **/
@Service
public class SkuService {
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

    public String getStringStandard(List<Integer> standardValues){
        StringBuilder stringBuilder = new StringBuilder();
        String standardName;
        ProductValueEntity productValueEntity;
        for(int i = 0;i<standardValues.size();i++){
            productValueEntity = productValueMapper.getProductValueById(standardValues.get(i));
            standardName = productNameMapper.getNameByProductNameId(productValueEntity.getProductNameId());
            stringBuilder.append(standardName+":"+productValueEntity.getProductName());
            if(i!=standardValues.size()-1){
                stringBuilder.append(";");
            }
        }
        return stringBuilder.toString();
    }
}
