package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.CategoriesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 17:23
 * @email: 630268696@qq.com
 **/
@Mapper
@Repository
public interface CategoriesMapper {
    int addCategories(CategoriesEntity CategoriesEntity);
    int deleteCategoriesById(int id);
    int updateCategoriesById(CategoriesEntity CategoriesEntity);
    CategoriesEntity getCategoriesByClassifyId(int classifyId);
    CategoriesEntity getCategoriesByClassifyName(String classifyName);
    int isClassifyNameExists(String classifyName);
}
