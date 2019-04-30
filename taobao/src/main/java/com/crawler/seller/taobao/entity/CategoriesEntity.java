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
 * @create: 2019-04-15 16:26
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
public class CategoriesEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int classifyId;
    String classifyName;
    int fatherId;

    public CategoriesEntity(String classifyName, int fatherId) {
        this.classifyName = classifyName;
        this.fatherId = fatherId;
    }

    public CategoriesEntity(String classifyName) {
        this.classifyName = classifyName;
    }

}
