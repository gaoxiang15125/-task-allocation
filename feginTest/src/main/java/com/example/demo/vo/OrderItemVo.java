package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-19 08:51
 * @email: 630268696@qq.com
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemVo {
    int goodsId;
    String sku;
    String imgURL;
    String goodsName;
}
