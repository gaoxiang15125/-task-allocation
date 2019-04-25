package com.onlineseller.statistic.charts.interfaceservice;

import com.onlineseller.statistic.charts.vo.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-24 16:02
 * @email: 630268696@qq.com
 **/
@Component
public class OrderInfoController {

    public List<Order> getOrderBySellerId(int sellerId,Timestamp beginsTime,Timestamp endsTime){
        return null;
    }

    public List<Order> getOrderByUserId(int userId,Timestamp beginsTime,Timestamp endsTime){
        return null;
    }

    public List<Order> getOrderByGoodsId(int goodsId,Timestamp beginsTime,Timestamp endsTime){
        return null;
    }

    public List<Order> getAllOrder(Timestamp beginsTime,Timestamp endsTime){
        return null;
    }


}
