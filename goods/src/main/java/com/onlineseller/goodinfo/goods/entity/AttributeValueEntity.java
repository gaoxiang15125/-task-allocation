package com.onlineseller.goodinfo.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class AttributeValueEntity {
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
