package com.onlineseller.goodinfo.goods.dao;

import com.onlineseller.goodinfo.goods.entity.SpuEntity;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-12 10:35
 * @email: 630268696@qq.com
 **/
@Mapper
public interface SpuMapper {
    //基础的数据操作接口
    int addSpu(SpuEntity spuEntity);
    int deleteSpuById(Integer goodid);
    int updateSpuBuId(SpuEntity spuEntity);
    //获取指定Id 的Spu 商品对象
    SpuEntity getSpuById(Integer goodid);
    //获取所有Spu 的方法
    List<SpuEntity> getAllSpu();
    //获取特定Spu对象方法
    List<SpuEntity> getSpuByLikeName();
    List<SpuEntity> getSpuBySellerId(Integer sellerId);
    List<SpuEntity> getSpuByClassifyId(Integer classifyId);

}
