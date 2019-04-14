package com.client.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-09 09:21
 * @email: 630268696@qq.com
 **/
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        //存储访问信息实例的对象
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host: "+ instance.getHost()+" , service_id: "+instance.getServiceId());
        return "hello world";
    }
}
