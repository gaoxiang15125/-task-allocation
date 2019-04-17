package com.onlineseller.goodinfo.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class CategoriesEntity {

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
