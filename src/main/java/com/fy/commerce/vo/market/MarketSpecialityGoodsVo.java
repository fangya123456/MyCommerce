package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ya.fang on 2017/9/18.
 * 特色商品
 */
public class MarketSpecialityGoodsVo implements Serializable{

    private Long psgId;
    private String pdtSku;
    private String pdtName;
    private String brandName;
    private String modelNumber;
    private BigDecimal salePrice;
    private BigDecimal onlinePrice;
    private String shopName;
    private String picUrl;
    private String seriesName;
    private Integer showOnly;

    public Long getPsgId() {
        return psgId;
    }

    public void setPsgId(Long psgId) {
        this.psgId = psgId;
    }

    public String getPdtSku() {
        return pdtSku;
    }

    public void setPdtSku(String pdtSku) {
        this.pdtSku = pdtSku;
    }

    public String getPdtName() {
        return pdtName;
    }

    public void setPdtName(String pdtName) {
        this.pdtName = pdtName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getOnlinePrice() {
        return onlinePrice;
    }

    public void setOnlinePrice(BigDecimal onlinePrice) {
        this.onlinePrice = onlinePrice;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Integer getShowOnly() {
        return showOnly;
    }

    public void setShowOnly(Integer showOnly) {
        this.showOnly = showOnly;
    }

    public MarketSpecialityGoodsVo(){}
}
