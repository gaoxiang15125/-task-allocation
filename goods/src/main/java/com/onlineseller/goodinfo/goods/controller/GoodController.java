package com.onlineseller.goodinfo.goods.controller;

import com.onlineseller.goodinfo.goods.service.GoodsService;
import com.onlineseller.goodinfo.goods.vo.CartItemVo;
import com.onlineseller.goodinfo.goods.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-16 11:48
 * @email: 630268696@qq.com
 **/
@Controller
@RequestMapping(name = "/goods")
public class GoodController {
    @Autowired
    GoodsService goodsService;
    //该对象用于获取访问请求的上下文信息，此处不需要使用
//    @Autowired
//    private DiscoveryClient client;

    @RequestMapping(value = "/addNewGoods",method= RequestMethod.GET)
    public boolean addNewGoods(GoodsVo goodsVo){
        return  goodsService.addGoodsVo(goodsVo);
    }

    @RequestMapping(value = "/getGoodsById",method = RequestMethod.GET)
    public GoodsVo getGoodsById(int goodsId){
        return goodsService.getGoodsVoById(goodsId);
    }

    @RequestMapping(value = "/getGoodsBySellerId",method = RequestMethod.GET)
    public List<GoodsVo> getGoodsBySellerID(int sellerId){
        return goodsService.getGoodsVoBySellerId(sellerId);
    }

    @RequestMapping(value = "/getGoodsByClassifyId",method = RequestMethod.GET)
    public List<GoodsVo> getGoodsByClassifyID(int classifyID){
        return goodsService.getGoodsVoByClassifyId(classifyID);
    }

    @RequestMapping(value = "/getAllGoods",method = RequestMethod.GET)
    public List<GoodsVo> getAllGoods(){
        return goodsService.getAllGoods();
    }

    @RequestMapping(value = "/getGoodsByLikeName",method = RequestMethod.GET)
    public List<GoodsVo> getGoodsByLikName(String name){
        return goodsService.getGoodsByLikeName(name);
    }

    //订单模块需要的接口
    @RequestMapping(value = "/getCartItemBySkus",method = RequestMethod.GET)
    public List<CartItemVo> getCartItemVOs(List<String> sku){
//        for(String sku:skus){
//
//        }
//        for()
        return null;
    }
    @RequestMapping(value = "/SkuValid",method = RequestMethod.GET)
    public String SkuValid(String sku){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    @GetMapping("/changeGoods")
    public boolean changeGoods(GoodsVo goodsVo){

    }
}
