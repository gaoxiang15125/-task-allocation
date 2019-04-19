package com.onlineseller.goodinfo.goods.controller;

import com.onlineseller.goodinfo.goods.service.GoodsService;
import com.onlineseller.goodinfo.goods.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class GoodController {
    @Autowired
    GoodsService goodsService;

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

}
