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
 * @create: 2019-04-15 17:21
 * @email: 630268696@qq.com
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attribute_names")
public class AttributeNameEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int qualityId;
    String qualityName;
    public AttributeNameEntity(String qualityName) {
        this.qualityName = qualityName;
    }
}
