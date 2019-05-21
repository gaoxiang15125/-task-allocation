package com.onlineseller.statistic.charts.controller;

import com.onlineseller.statistic.charts.vo.GoodsShowVo;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/getCharsInfoForSeller",method = RequestMethod.GET)
    public List<GoodsShowVo> getChartsInfoForSeller(int sellerId){

        return null;
    }
    @RequestMapping(value = "/getChartsInfoForUser",method = RequestMethod.GET)
    public List<GoodsShowVo> getChartsInfoForUser(int clientId){

        return null;
    }
    @RequestMapping(value = "/getChartsInfoForRoot",method = RequestMethod.GET)
    public List<GoodsShowVo> getChartsInfoForRoot(){

        return null;
    }
}
