package com.crawler.seller.taobao.dao;

import com.crawler.seller.taobao.entity.ProductNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: taobao
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-24 14:55
 * @email: 630268696@qq.com
 **/
public interface ProductNameDao extends JpaRepository<ProductNameEntity,Integer> {
    //有个save方法就足够用了，不需要手写任何方法
    boolean existsByProductName(String productName);
    ProductNameEntity findProductNameEntityByProductName(String productName);
}
