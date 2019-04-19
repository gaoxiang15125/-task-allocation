package com.onlineseller.goodinfo.goods.vo;

import lombok.*;

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
