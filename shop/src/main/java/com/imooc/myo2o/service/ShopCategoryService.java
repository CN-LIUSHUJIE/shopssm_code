package com.imooc.myo2o.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.imooc.myo2o.dto.ShopCategoryExecution;
import com.imooc.myo2o.entity.ShopCategory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author LIUSHUJIE
 * @date 2019/6/10 11:27
 */
public interface ShopCategoryService {
    List<Map<String, Object>> queryShopCategory();

    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @return List<ProductCategory>
     * @throws JsonProcessingException
     * @throws IOException
     */
//    List<Map<String,Object>> getFirstLevelShopCategoryList() throws IOException;

    ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory,
                                             CommonsMultipartFile thumbnail, boolean thumbnailChange);
}
