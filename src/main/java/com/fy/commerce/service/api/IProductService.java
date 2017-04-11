package com.fy.commerce.service.api;

import com.fy.commerce.model.Category;
import com.fy.commerce.model.CategorySecond;
import com.fy.commerce.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by ya.fang on 2017/1/17.
 */
public interface IProductService {

    Product findProductInfoById(int id);

    List<Product> findProductInfoByProductName(String productName);

    List<Product> findProductInfoByCategorySecondName(String categorySecondName);

    Boolean addProductInfo(Product product);

    List<Category> getCategoryInfoList();

    List<CategorySecond> getCategorySecondInfoList();

    Map<String, Object> getCategoryAndCategorySecondInfo();

    List<Product> getProductInfoByPage(int page, int pageSize);

    List<Product> getHotProductInfoByPage(int page, int pageSize);

}
