package com.imooc.myo2o.dao;

import com.imooc.myo2o.BaseTest;
import com.imooc.myo2o.entity.Shop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopDaoTest extends BaseTest {
    @Autowired
    private  ShopDao shopDao;

    @Test
    public void testCQueryByShopId(){
        long shopId = 15;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop);
    }
}
