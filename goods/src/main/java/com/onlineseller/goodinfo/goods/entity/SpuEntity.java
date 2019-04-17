package com.onlineseller.goodinfo.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-12 10:21
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuEntity {
    //商品ID
    int goodId;
    String description;
    //图片url资源，使用‘ ’进行分割
    String picUrl;
    //商品的用户评分，根据用户评论进行计算
    double goodScore;
    //商品的品牌信息
    int brandId;
    //商品归属的商铺id
    int sellerId;
    //商品归属的分类，为了直观，采用分类内容进行存储，直接用分类名称作为key值(保留）
    int classifyId;
    //商品名称
    String name;
    //商品基础价格
    double price;

    public SpuEntity(String description, String picUrl, double goodScore, int brandId, int sellerId, int classifyId, String name, double price) {
        this.description = description;
        this.picUrl = picUrl;
        this.goodScore = goodScore;
        this.brandId = brandId;
        this.sellerId = sellerId;
        this.classifyId = classifyId;
        this.name = name;
        this.price = price;
    }
}
