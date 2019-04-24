package com.onlineseller.statistic.charts.vo;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsShowVo {
	String goodsName;
	int goodsId;
	Map<String,GoodsSkuVo> goodsSkuVoMap;
	double price;
	int sellNum;
}
