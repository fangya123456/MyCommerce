package com.fy.commerce.mapper;

import com.fy.commerce.model.Category;

import java.util.List;

/**
 * Created by ya.fang on 2017/1/16.
 */
public interface ICategoryMapper {

    List<Category> selectAllCategoryInfo();

    Category selectCategoryInfoById(int cid);

    Category selectCategoryInfoByExample(Category category);

    int insertCategoryInfoByExample(Category category);

    int updateCategoryInfoById(int cid);

    int deleteCategoryById(int cid);

    int deleteCategoryByExample(Category category);
}
