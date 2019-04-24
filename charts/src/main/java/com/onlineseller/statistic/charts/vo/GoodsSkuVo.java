package com.onlineseller.statistic.charts.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-24 17:08
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSkuVo {
    String skuId;
    String goodsName;
    double price;
    int sellerNum;
}
