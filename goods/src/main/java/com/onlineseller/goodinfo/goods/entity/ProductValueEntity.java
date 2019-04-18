package com.onlineseller.goodinfo.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 14:22
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductValueEntity {

    int id;
    int goodsId;
    String productName;
    int productNameId;
    double moneyChange;
    String picUrl;

    public ProductValueEntity(int goodsId, String productName, int productNameId, double moneyChange,String picUrl) {
        this.goodsId = goodsId;
        this.productName = productName;
        this.productNameId = productNameId;
        this.moneyChange = moneyChange;
        this.picUrl = picUrl;
    }
}
