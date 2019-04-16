package com.onlineseller.goodinfo.goods.service;

import com.onlineseller.goodinfo.goods.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public
}
