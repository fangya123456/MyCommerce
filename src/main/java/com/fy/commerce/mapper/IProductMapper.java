package com.fy.commerce.mapper;

import com.fy.commerce.model.Product;

import java.util.List;

/**
 * Created by ya.fang on 2017/1/17.
 */
public interface IProductMapper {

    List<Product> selectAllProductInfo();

    Product selectProductInfoById(int pid);

    Product selectProductInfoByExample(Product product);

    List<Product> selectProductInfoByForeignKey(int csid);

    int insertProductInfo(Product product);

    int updateProductInfo(Product product);

    int deleteProductInfoById(int pid);

    int deleteProductInfoByExample(Product product);

}
