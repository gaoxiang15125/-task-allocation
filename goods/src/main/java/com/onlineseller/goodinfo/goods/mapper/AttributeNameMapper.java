package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.AttributeNameEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 17:22
 * @email: 630268696@qq.com
 **/
@Mapper
@Repository
public interface AttributeNameMapper {
    int addAttributeName(AttributeNameEntity attributeNameEntity);
    int deleteAttributeNameById(int qualityId);
    int updateAttributeNameById(AttributeNameEntity attributeNameEntity);
    AttributeNameEntity getAttributeNameByQualityId(int qualityId);
    int isAttributeNameExists(String qualityName);
}
