package com.onlineseller.goodinfo.goods.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-05-11 15:01
 * @email: 630268696@qq.com
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1000)
                .allowedOrigins("*");
    }
}
