package com.onlineseller.goodinfo.goods.controller;

import com.onlineseller.goodinfo.goods.entity.SkuEntity;
import com.onlineseller.goodinfo.goods.mapper.SkuMapper;
import com.onlineseller.goodinfo.goods.service.GoodsService;
import com.onlineseller.goodinfo.goods.service.SkuService;
import com.onlineseller.goodinfo.goods.tool.EntityVoChangeTools;
import com.onlineseller.goodinfo.goods.tool.GatherTools;
import com.onlineseller.goodinfo.goods.vo.CartItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-22 09:13
 * @email: 630268696@qq.com
 **/
@Controller
@RequestMapping(name = "/OrderGoodsService")
public class OrderGoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    SkuService skuService;
    @Autowired
    SkuMapper skuMapper;
    //订单模块需要的接口
    @RequestMapping(value = "/getCartItemBySkus",method = RequestMethod.GET)
    public List<CartItemVo> getCartItemVOs(List<String> skus){
        List<CartItemVo> cartItemVos = new ArrayList<>();
        SkuEntity skuEntity;
        String goodsName;
        for(String string:skus){
            skuEntity = skuMapper.getSkuByProductId(string);
            goodsName = goodsService.getGoodsNameById(skuEntity.getGoodId());
            cartItemVos.add(EntityVoChangeTools.changeSkuEntityToCartItemVo(skuEntity,goodsName));
        }
        return cartItemVos;
    }

    @RequestMapping(value = "/SkuValid",method = RequestMethod.GET)
    public String SkuValid(String sku){
        String[] skus = sku.split(GatherTools.standardTag);
        List<Integer> skuIDs = new ArrayList<>();
        for(int i=0;i<skus.length;i++){
            skuIDs.add(Integer.parseInt(skus[i]));
        }
        return skuService.getStringStandard(skuIDs);
    }
}
