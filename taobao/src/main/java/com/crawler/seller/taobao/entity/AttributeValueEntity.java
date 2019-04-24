package com.crawler.seller.taobao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 17:17
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attribute_values")
public class AttributeValueEntity {
    @Id
    int id;
    int qualityId;
    String qualityValue;
    int goodsId;
    public AttributeValueEntity(int qualityId, String qualityValue, int goodsId) {
        this.qualityId = qualityId;
        this.qualityValue = qualityValue;
        this.goodsId = goodsId;
    }

}
