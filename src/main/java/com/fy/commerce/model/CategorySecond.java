package com.fy.commerce.model;

import java.io.Serializable;

/**
 * Created by ya.fang on 2017/1/16.
 */
public class CategorySecond implements Serializable {

    /**
     * 二级分类ID
     * */
    private int csid;

    /**
     * 二级分类类名
     * */
    private String csname;

    /**
     * 一级分类ID
     * */
    private int cid;

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
