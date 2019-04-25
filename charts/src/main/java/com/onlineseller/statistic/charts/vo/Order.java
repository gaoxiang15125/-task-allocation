package com.onlineseller.statistic.charts.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class Order {
	//订单id主键
	private long id;
	//订单关联的用户的id，即买家id
	private int userid;
	//订单关联的商铺的id，即卖家id
	private int storeid;
	//订单关联的用户地址的id，送货地址
	private int addressid;
	//下单事件
	private Timestamp time;
	//订单总金额
	private double money;
	//订单状态（0-用户已删除/对用户不显示，1-待付款，2-待发货，3-待收货，4-待评价，5-申请退款，6-申请退款成功，7-退款成功...）
	private int status;
	//用户打分：服务评价1~5分
	private int service_score;
	//用户打分：物流评价1~5分
	private int transport_score;
	//订单项列表
	private List<OrderItem> items;
}
