package com.soler.finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-09 15:11
 * @email: 630268696@qq.com
 **/
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();

    }
}
