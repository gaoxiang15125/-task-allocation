package com.onlineseller.statistic.charts.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class Order {

	private long id;
	private int userId;
	private int storeId;
	private int addressId;
	private Timestamp time;
	private double money;
	private int status;
	private int service_score;
	private int transport_score;
	private List<OrderItem> items;
}
