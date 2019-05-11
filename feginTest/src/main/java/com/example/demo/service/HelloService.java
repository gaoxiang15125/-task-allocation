package com.example.demo.service;

import com.example.demo.vo.GoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-05-11 13:41
 * @email: 630268696@qq.com
 **/
@FeignClient("goodsservic")
public interface HelloService {
    @RequestMapping("/getGoodsBySellerId")
    List<GoodsVo> getGoodsBySellerID(@RequestParam int id);
}
