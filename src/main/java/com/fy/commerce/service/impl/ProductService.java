package com.fy.commerce.service.impl;

import com.fy.commerce.dao.CategoryMapper;
import com.fy.commerce.dao.CategorySecondMapper;
import com.fy.commerce.dao.ProductMapper;
import com.fy.commerce.model.*;
import com.fy.commerce.service.api.IProductService;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by ya.fang on 2017/1/17.
 */
@Service
public class ProductService implements IProductService {

    private final Logger log = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategorySecondMapper categorySecondMapper;


    @Override
    public Product findProductInfoById(int id){
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> findProductInfoByProductName(String productName){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductNameEqualTo(productName);
        return productMapper.selectByCategorySecondName(productName);
    }

    @Override
    public List<Product> findProductInfoByCategorySecondName(String categorySecondName){

        return productMapper.selectByCategorySecondName(categorySecondName);
    }

    @Override
    @Transactional
    public Boolean addProductInfo(Product product){
        if (productMapper.insert(product) > 0){
            return true;
        }else {
            return false;
        }
    }

    public List<Category> getCategoryInfoList(){
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria();
        return categoryMapper.selectByExample(categoryExample);
    }

    public List<CategorySecond> getCategorySecondInfoList(){
        CategorySecondExample categorySecondExample = new CategorySecondExample();
        categorySecondExample.createCriteria();
        return categorySecondMapper.selectByExample(categorySecondExample);
    }

    @Cacheable(value = "CategoryInfo")
    public Map<String, Object> getCategoryAndCategorySecondInfo(){
        //log.info("getCategoryAndCategorySecondInfo:=======缓存商品分类信息");
        Map<String, Object> map = new HashMap<>();
        List<Category> categoryList = this.getCategoryInfoList();
        if (categoryList.size() > 0){
            CategorySecondExample categorySecondExample = new CategorySecondExample();
            for (Category category: categoryList) {
                //log.info(category.getCid() + ": " + category.getCname());
                categorySecondExample.createCriteria().andCategoryIdEqualTo(category.getId());
                map.put(category.getCategoryName(), categorySecondMapper.selectByExample(categorySecondExample));
                categorySecondExample.clear();
            }
        }
        return map;
    }

    @Cacheable(value = "ProductInfo")
    public List<Product> getProductInfoByPage(int page, int pageSize){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria();
        PageHelper.startPage(page, pageSize);
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }

    public List<Product> getHotProductInfoByPage(int page, int pageSize){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIsHotEqualTo(1);
        PageHelper.startPage(page, pageSize);
        List<Product> hotProductList = productMapper.selectByExample(productExample);
        return hotProductList;
    }

    public int getProductTotalPage(){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIsDelEqualTo(0);
        return productMapper.countByExample(productExample)/20;
    }

}
