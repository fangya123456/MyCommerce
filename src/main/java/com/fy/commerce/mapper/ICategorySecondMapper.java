package com.fy.commerce.mapper;

import com.fy.commerce.model.CategorySecond;

import java.util.List;

/**
 * Created by ya.fang on 2017/1/17.
 */
public interface ICategorySecondMapper {

    List<CategorySecond> selectAllCategorySecondInfo();

    CategorySecond selectCategorySecondInfoById(int csid);

    CategorySecond  selectCategorySecondInfoByExample(CategorySecond categorySecond);

    List<CategorySecond> selectCategorySecondInfoByForeignKey(int cid);

    int insertCategorySecondInfo(CategorySecond categorySecond);

    int updateCategorySecondInfo(CategorySecond categorySecond);

    int deleteCategorySecondInfoById(int csid);
}
