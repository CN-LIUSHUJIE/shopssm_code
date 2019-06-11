package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.ShopCategory;

import java.util.List;
import java.util.Map;

/**
 * @author LIUSHUJIE
 * @date 2019/6/10 11:25
 */
public interface ShopCategoryDao {
    List<Map<String,Object>> queryShopCategory();

    /**
     * 通过id查询单条记录
     * @param shopCategoryId
     * @return
     */
    ShopCategory queryShopCategoryById(long shopCategoryId);

    /**
     * 更新 商品类别
     * @param shopCategory
     * @return
     */
    int updateShopCategory(ShopCategory shopCategory);

}
