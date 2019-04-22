package com.onlineseller.statistic.charts.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
	private long orderId;
	private String skuId;
	private double price;
	private int number;
	private int score;
}
