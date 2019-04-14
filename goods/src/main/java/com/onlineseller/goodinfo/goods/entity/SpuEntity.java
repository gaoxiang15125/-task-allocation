package com.onlineseller.goodinfo.goods.entity;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-12 10:21
 * @email: 630268696@qq.com
 **/

public class SpuEntity {
    //商品ID
    int goodid;
    String description;
    //图片url资源，使用‘ ’进行分割
    String picurl;
    //商品的用户评分，根据用户评论进行计算
    double goodscord;
    //商品的品牌信息
    int brandid;
    //商品归属的商铺id
    int sellerid;
    //商品归属的分类，为了直观，采用分类内容进行存储，直接用分类名称作为key值(保留）
    int classifyid;
    //商品的基础价格
    double price;
}
