package com.crawler.seller.taobao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: demo
 * @Description: 型号信息存储实体类
 * @author: Mr.gao
 * @create: 2019-04-15 14:06
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sku")
public class SkuEntity {
    @Id
    String productId;
    int goodId;
    double price;
    String picUrl;

    public SkuEntity(int goodId, double price, String picUrl) {
        this.goodId = goodId;
        this.price = price;
        this.picUrl = picUrl;
    }
}
