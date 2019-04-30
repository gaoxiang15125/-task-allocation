package com.crawler.seller.taobao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 14:19
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "standard_names")
public class ProductNameEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int productNameId;
    String productName;

    public ProductNameEntity(String productName) {
        this.productName = productName;
    }
}
