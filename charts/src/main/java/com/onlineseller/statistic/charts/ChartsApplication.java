package com.onlineseller.statistic.charts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.websocket.ClientEndpoint;

@EnableDiscoveryClient
@SpringBootApplication
public class ChartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChartsApplication.class, args);
    }

}
