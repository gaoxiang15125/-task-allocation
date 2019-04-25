package com.onlineseller.statistic.charts.controller;

import com.onlineseller.statistic.charts.vo.GoodsShowVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-22 14:10
 * @email: 630268696@qq.com
 **/
@RestController
@RequestMapping(value = "/chartsInfo")
public class ChartsController {

    public List<GoodsShowVo> getChartsInfoForSeller(int sellerId){
        return null;
    }

    public List<GoodsShowVo> getChartsInfoForUser(int clientId){
        return null;
    }

    public List<GoodsShowVo> getChartsInfoForRoot(){
        return null;
    }
}
