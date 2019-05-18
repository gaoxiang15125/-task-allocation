package com.example.demo.service;

import com.example.demo.hehe.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-05-18 11:41
 * @email: 630268696@qq.com
 **/
@FeignClient("ORDER")
public interface OrderService {
    @RequestMapping("/orders4user")
    List<Order> getOrdersOfUser(@RequestParam int userid);
}
