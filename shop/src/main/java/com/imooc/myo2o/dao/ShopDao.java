package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Shop;

public interface ShopDao {
    /**
     * 通过shop id 查询店铺
     */
    Shop queryByShopId(long shopId);
}
