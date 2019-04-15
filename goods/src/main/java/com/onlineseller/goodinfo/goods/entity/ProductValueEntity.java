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
    int productId;
    String productName;
    int productNameId;
}
