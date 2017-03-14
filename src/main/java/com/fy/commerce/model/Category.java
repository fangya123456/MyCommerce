package com.fy.commerce.model;

import java.io.Serializable;

/**
 * Created by ya.fang on 2017/1/16.
 * 一级分类
 */
public class Category implements Serializable {

    /**
    * 一级分类ID
     * */
    private int cid;

    /**
     * 一级分类类名
     * */
    private String cname;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
