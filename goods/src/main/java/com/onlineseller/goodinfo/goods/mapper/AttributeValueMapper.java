package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.AttributeValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-15 17:22
 * @email: 630268696@qq.com
 **/
@Mapper
@Repository
public interface AttributeValueMapper {

    int addAttributeValue(AttributeValueEntity attributeValueEntity);
    int deleteAttributeValueById(int id);
    int updateAttributeValueById(AttributeValueEntity attributeValueEntity);
    List<AttributeValueEntity> getAttributeValueByGoodsId(int goodsId);

}
