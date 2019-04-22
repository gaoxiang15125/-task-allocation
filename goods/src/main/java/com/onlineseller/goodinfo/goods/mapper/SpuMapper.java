package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.SpuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-12 10:35
 * @email: 630268696@qq.com
 **/
@Mapper
@Repository
public interface SpuMapper {
    //基础的数据操作接口
    int addSpu(SpuEntity spuEntity);
    int deleteSpuById(int goodId);
    int deleteSpuByIDThroughStatus(int goodId);
    int updateSpuById(SpuEntity spuEntity);
    //获取指定Id 的Spu 商品对象
    SpuEntity getSpuById(int goodId);
    //获取所有Spu 的方法
    List<SpuEntity> getAllSpu();
    //获取特定Spu对象方法
    List<SpuEntity> getSpuByLikeName(String likeWord);
    List<SpuEntity> getSpuBySellerId(int sellerId);
    List<SpuEntity> getSpuByClassifyId(int classifyId);

}
