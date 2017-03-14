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

    Product findProductInfo(Product product);

    List<Product> findProductInfoByForeignKey(int csid);

    Boolean addProductInfo(Product product);

    Boolean updateProductInfo(Product product);

    Boolean deleteProductInfoById(int id);

    Boolean deleteProductInfo(Product product);

    List<Category> getAllCategoryInfo();

    List<CategorySecond> getAllCategorySecondInfo();

    Map<String, Object> getCategoryAndCategorySecondInfo();

    List<Product> getAllProductInfo();

    List<Product> getProductInfoByPage(int page, int pageSize);

    long getCountProductList(List<Product> list);
}
