package com.example.demo.controller;

import com.example.demo.hehe.Order;
import com.example.demo.service.HelloService;
import com.example.demo.service.OrderService;
import com.example.demo.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-05-11 13:44
 * @email: 630268696@qq.com
 **/
@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public List<GoodsVo> getAllGoodsBySellerId(int id){
        return helloService.getGoodsBySellerID(id);
    }

    @RequestMapping(value = "/order4User",method = RequestMethod.GET)
    public List<Order> getUserOrderByUserID(int userID){
        System.out.println("~~~~~~~~~~~~~");
        return orderService.getOrdersOfUser(userID);
    }
//    @RequestMapping("/test")
//    public boolean getTest(){
//        //return helloService.getTest();
//    }
}
