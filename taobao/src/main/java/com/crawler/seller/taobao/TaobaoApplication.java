package com.crawler.seller.taobao;

import com.crawler.seller.taobao.pagecrawler.GoodsPageCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaobaoApplication {
    public static void main(String[] args) {
         SpringApplication.run(TaobaoApplication.class, args);
    }

}
