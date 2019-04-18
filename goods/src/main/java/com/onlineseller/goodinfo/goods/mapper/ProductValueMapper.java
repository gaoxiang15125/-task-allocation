package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.ProductValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 14:29
 * @email: 630268696@qq.com
 **/
@Mapper
@Repository
public interface ProductValueMapper {
    int addProductValue(ProductValueEntity productValueEntity);
    int deleteProductValueById(int id);
    int updateProductValueById(ProductValueEntity productValueEntity);
    List<ProductValueEntity> getProductValueByGoodsId(int goodsId);
}
