package com.crawler.seller.taobao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "spu")
public class SpuEntity {
    @Id
    //商品ID
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int goodId;
    String description;
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
    //图片url资源，使用‘ ’进行分割
    String picUrl;
    //商品基础价格
    double price;
    //商品的状态
    int status;

    public SpuEntity(String description, double goodScore, int brandId, int sellerId, int classifyId, String name, String picUrl, double price, int status) {
        this.description = description;
        this.goodScore = goodScore;
        this.brandId = brandId;
        this.sellerId = sellerId;
        this.classifyId = classifyId;
        this.name = name;
        this.picUrl = picUrl;
        this.price = price;
        this.status = status;
    }
}
