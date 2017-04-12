package com.fy.commerce.vo;

import java.io.Serializable;

/**
 * Created by dell-pc on 2017/4/12.
 */
public class CatergorySecondInfoVo implements Serializable{

    private Integer id;

    private String categorySecondName;

    private Integer categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategorySecondName() {
        return categorySecondName;
    }

    public void setCategorySecondName(String categorySecondName) {
        this.categorySecondName = categorySecondName == null ? null : categorySecondName.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
