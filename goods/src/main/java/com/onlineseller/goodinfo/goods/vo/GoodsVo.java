package com.onlineseller.goodinfo.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-16 14:19
 * @email: 630268696@qq.com
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo {
    //对应数据库位置，如非数据库中goodsVo则无初值，不向外部暴漏
    //int goodId;
    //商品信息描述
    String description;
    //用户对商品的评分，可以不显示
    double goodScore;
    //品牌信息
    String brand;
    //商品分类信息,String 中存储所属分类，直接get获取所属分类
    Map<Integer,String> classify;
    //图片Url存储链表，直接存储对应图片的Url
    List<String> picUrls;
    //商品的名称
    String goodsName;
    //该商品对应的商铺Id
    int sellerId;
    //该商品包含的型号信息采用型号vo进行存储管理

}
