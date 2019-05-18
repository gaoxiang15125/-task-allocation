package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
