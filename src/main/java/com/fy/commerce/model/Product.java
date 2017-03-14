package com.fy.commerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ya.fang on 2017/1/16.
 */
public class Product implements Serializable{

    /**
     * 商品ID
     * */
    private int pid;

    /**
     * 商品名
     * */
    private String pname;

    /**
    * 商城价
     * */
    private double marketPrice;

    /**
     * 店铺价
     * */
    private double shopPrice;

    /**
     * 商品图片url
     * */
    private String pimage;

    /**
     * 商品总数
     * */
    private int pnum;

    /**
     * 商品库存数
     * */
    private int pinvotory;

    /**
     * 商品描述
     * */
    private String pdesc;

    /**
     * 热门商品
     * 1： 是
     * 0： 否
     * */
    private int isHot;

    /**
     * 商品日期
     * */
    private Timestamp pdate;

    /**
     * 二级分类ID
     * */
    private int csid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getPinvotory() {
        return pinvotory;
    }

    public void setPinvotory(int pinvotory) {
        this.pinvotory = pinvotory;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public Timestamp getPdate() {
        return pdate;
    }

    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }
}
