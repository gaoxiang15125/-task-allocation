package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-19 08:47
 * @email: 630268696@qq.com
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemVo {
    String sku;
    String imgURL;
    double price;
    String goodsName;

}
