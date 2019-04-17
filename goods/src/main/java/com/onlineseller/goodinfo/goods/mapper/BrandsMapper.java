package com.onlineseller.goodinfo.goods.mapper;

import com.onlineseller.goodinfo.goods.entity.BrandsEntity;
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
public interface BrandsMapper {
    int addBrands(BrandsEntity brandsEntity);
    int deleteBrandsById(int id);
    int updateBrandsById(BrandsEntity brandsEntity);
    BrandsEntity getBrandsByBrandId(int brandId);
    BrandsEntity getBrandsByBrandName(String brandName);
    //仅仅获取商标ID
    int getBrandIdByBrandName(String brandName);
    int isBrandNameExist(String brandName);

}
