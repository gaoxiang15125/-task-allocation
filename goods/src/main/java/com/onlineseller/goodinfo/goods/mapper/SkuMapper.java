package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.SkuEntity;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 14:28
 * @email: 630268696@qq.com
 **/
public interface SkuMapper {
    int addSku(SkuEntity skuEntity);
    int deleteSkuById(int productId);
    int updateSkuById(SkuEntity skuEntity);
    List<SkuEntity> getSkuByGoodId(int goodId);
}
