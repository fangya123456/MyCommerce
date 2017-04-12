package com.fy.commerce.vo;

import java.io.Serializable;

/**
 * Created by dell-pc on 2017/4/12.
 */
public class CategoryInfoVo implements Serializable {

    private Integer id;

    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
}
