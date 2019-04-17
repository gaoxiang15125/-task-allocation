package com.onlineseller.goodinfo.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 17:16
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandsEntity {

    int brandId;
    String brandName;
    String description;

    public BrandsEntity(String brandName, String description) {
        this.brandName = brandName;
        this.description = description;
    }
}
