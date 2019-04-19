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
    //对应数据库位置，如非数据库中goodsVo则无初值
    int goodsID;
    //商品信息描述
    String description;
    //用户对商品的评分，可以不显示
    double goodsScore;
    //品牌信息
    String brand;
    //对品牌信息的详细描述
    String brandDescription;
    //商品分类信息,String 中存储所属分类,思考后决定使用List存储，父节点在前在后
    List<String> classifies;
    //图片Url存储链表，直接存储对应图片的Url
    List<String> picUrls;
    //商品的名称
    String goodsName;
    //该商品对应的商铺Id
    int sellerId;
    //商品价格
    double price;
    //该商品包含的型号属性信息以及可选的属性值，Map的key值为属性名称，value值为属性内容
    Map<String,Map<String,StandardVo>> standards;
    //型号ID本质上为属性ID的一种组合，在用户下单后生成，保留在本属性中，关于采用集合还是单一值在进行考虑
    //String standardID;
    //该商品整体的基本属性信息，以Map的形式存储
    Map<String,String> attributes;

}
