package com.example.demo.hehe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Order {
	private int id;
	private int userid;
	private int storeid;
	private int addressid;
	private Timestamp time;
	private double money;
	private int status;
	private int service_score;
	private int transport_score;
	private List<OrderItem> items;

	public Order(int userid, int storeid, int addressid, double money, int status) {
		this.userid = userid;
		this.storeid = storeid;
		this.addressid = addressid;
		this.money = money;
		this.status = status;
	}
}
