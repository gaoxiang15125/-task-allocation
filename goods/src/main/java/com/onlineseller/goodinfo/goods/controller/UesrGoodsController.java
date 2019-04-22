package com.onlineseller.goodinfo.goods.controller;

import com.onlineseller.goodinfo.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-22 09:12
 * @email: 630268696@qq.com
 **/
@Controller
@RequestMapping(name = "/goodsService")
public class UesrGoodsController {
    @Autowired
    GoodsService goodsService;
}
