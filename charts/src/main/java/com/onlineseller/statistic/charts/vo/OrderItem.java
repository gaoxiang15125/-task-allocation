package com.onlineseller.statistic.charts.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
	private int id;
	//商品Id用于检索商品
	private int spuid;
	//订单项所属订单的id
	private long orderid;
	//订单项对应商品的规格
	private String skuid;
	//订单项对应商品的购买价格，是下单时商品的价格、固定了
	private double price;
	//买的件数
	private int number;
	//用户评价：商品分数1~5分
	private int score;
}