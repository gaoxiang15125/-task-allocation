package com.onlineseller.statistic.charts.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    //商铺名称
    private String name;
    //店主id
    private int userid;
    //店铺头像
    private String sign;
    //店铺联系电话
    private String phone;
    //暂未到账的钱
    private double turnover;
    //地址（仅限城市）
    private String location;
    //注册时间
    private Date reg_time;
}
