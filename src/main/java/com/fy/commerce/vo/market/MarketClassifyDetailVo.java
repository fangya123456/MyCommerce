package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ya.fang on 2017/9/18.
 */
public class MarketClassifyDetailVo implements Serializable {

    private List<MarketAdverVo> adver;           //商场广告
    private List<MarketProductVo> product;
    private List<MarketProductVo> venue;
    private List<MarketProductVo> experience;    //特色体验
    private String sales_collection;

    public List<MarketAdverVo> getAdver() {
        return adver;
    }

    public void setAdver(List<MarketAdverVo> adver) {
        this.adver = adver;
    }

    public List<MarketProductVo> getProduct() {
        return product;
    }

    public void setProduct(List<MarketProductVo> product) {
        this.product = product;
    }

    public List<MarketProductVo> getVenue() {
        return venue;
    }

    public void setVenue(List<MarketProductVo> venue) {
        this.venue = venue;
    }

    public List<MarketProductVo> getExperience() {
        return experience;
    }

    public void setExperience(List<MarketProductVo> experience) {
        this.experience = experience;
    }

    public String getSales_collection() {
        return sales_collection;
    }

    public void setSales_collection(String sales_collection) {
        this.sales_collection = sales_collection;
    }

    public MarketClassifyDetailVo(){}
}
