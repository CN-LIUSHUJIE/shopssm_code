package com.imooc.myo2o.service.impl;

import com.imooc.myo2o.dao.ShopCategoryDao;
import com.imooc.myo2o.dto.ShopCategoryExecution;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.enums.ShopCategoryStateEnum;
import com.imooc.myo2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LIUSHUJIE
 * @date 2019/6/10 11:27
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    private static String SCLISTKEY = "shopcategorylist";

    @Autowired
    ShopCategoryDao shopCategoryDao;

    @Override
    public List<Map<String, Object>> queryShopCategory() {
        List<Map<String, Object>> shopCategoryList = this.shopCategoryDao.queryShopCategory();
        return shopCategoryList;
    }

    @Override
    public ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory, CommonsMultipartFile thumbnail, boolean thumbnailChange) {
        if (shopCategory.getShopCategoryId() != null && shopCategory.getShopCategoryId() > 0) {
            shopCategory.setLastEditTime(new Date());
            if (thumbnail != null && thumbnailChange == true) {
                ShopCategory tempShopCategory = shopCategoryDao.queryShopCategoryById(shopCategory.getShopCategoryId());
                if (tempShopCategory.getShopCategoryImg() != null) {
                }
            }
            try {

                int effectedNum = shopCategoryDao
                        .updateShopCategory(shopCategory);
                if (effectedNum > 0) {
                    return new ShopCategoryExecution(
                            ShopCategoryStateEnum.SUCCESS, shopCategory);
                } else {
                    return new ShopCategoryExecution(
                            ShopCategoryStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("更新店铺类别信息失败:" + e.toString());

            }
        } else {
            return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
        }
    }

    //    @Override
//    public List<ShopCategory> getFirstLevelShopCategoryList() throws IOException {
//        return null;
//    }
}
