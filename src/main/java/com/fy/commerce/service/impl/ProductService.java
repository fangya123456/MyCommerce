package com.fy.commerce.service.impl;

import com.fy.commerce.mapper.ICategoryMapper;
import com.fy.commerce.mapper.ICategorySecondMapper;
import com.fy.commerce.mapper.IProductMapper;
import com.fy.commerce.model.Category;
import com.fy.commerce.model.CategorySecond;
import com.fy.commerce.model.Product;
import com.fy.commerce.service.api.IProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import org.apache.log4j.Logger;
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

    //private final Logger log = Logger.getLogger(ProductService.class);

    @Autowired
    private IProductMapper productMapper;

    @Autowired
    private ICategoryMapper categoryMapper;

    @Autowired
    private ICategorySecondMapper categorySecondMapper;


    @Override
    public Product findProductInfoById(int id){

        return productMapper.selectProductInfoById(id);
    }

    @Override
    public Product findProductInfo(Product product){

        return productMapper.selectProductInfoByExample(product);
    }

    @Override
    public List<Product> findProductInfoByForeignKey(int csid){

        return productMapper.selectProductInfoByForeignKey(csid);
    }

    @Override
    @Transactional
    public Boolean addProductInfo(Product product){
        if (productMapper.insertProductInfo(product) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean updateProductInfo(Product product){
        if (productMapper.updateProductInfo(product) > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean deleteProductInfoById(int id){
        if (productMapper.deleteProductInfoById(id) > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean deleteProductInfo(Product product){
        if (productMapper.deleteProductInfoByExample(product) > 0){
            return true;
        }else {
            return false;
        }
    }

    public List<Category> getAllCategoryInfo(){

        return categoryMapper.selectAllCategoryInfo();
    }

    public List<CategorySecond> getAllCategorySecondInfo(){

        return categorySecondMapper.selectAllCategorySecondInfo();
    }

    @Cacheable(value = "CACSI")
    public Map<String, Object> getCategoryAndCategorySecondInfo(){
        //log.info("getCategoryAndCategorySecondInfo:=======缓存商品分类信息");
        Map<String, Object> map = new HashMap<>();
        List<Category> categoryList = categoryMapper.selectAllCategoryInfo();

        if (categoryList.size() > 0){
            for (Category category: categoryList) {
                //log.info(category.getCid() + ": " + category.getCname());
                map.put(category.getCname(), categorySecondMapper.selectCategorySecondInfoByForeignKey(category.getCid()));
            }
        }
        return map;
    }

    public List<Product> getAllProductInfo(){

       return productMapper.selectAllProductInfo();

    }

    public List<Product> getProductInfoByPage(int page, int pageSize){

        PageHelper.startPage(page, pageSize);
        List<Product> productList = productMapper.selectAllProductInfo();
        //log.debug(productList);
        return productList;
    }

    public long getCountProductList(List<Product> list){

        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo.getTotal();
    }
}
