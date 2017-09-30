package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ya.fang on 2017/9/14.
 * 商场列表展示页商场展示VO
 */
public class MarketShowVo implements Serializable{

    private Integer carport;   			//车位数量
    private String city_id;   			//城市ID
    private String city_name;			//城市名称
    private BigDecimal distance;			//距离
    private long id;			//主键Id
    private String market_address;		//商场地址
    private String market_name;		//商场名称
    private String market_pic;			//商场图片
    private String market_short;		//商场简称
    private Integer shop_number;		//品牌数量

    public Integer getCarport() {
        return carport;
    }

    public void setCarport(Integer carport) {
        this.carport = carport;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarket_address() {
        return market_address;
    }

    public void setMarket_address(String market_address) {
        this.market_address = market_address;
    }

    public String getMarket_name() {
        return market_name;
    }

    public void setMarket_name(String market_name) {
        this.market_name = market_name;
    }

    public String getMarket_pic() {
        return market_pic;
    }

    public void setMarket_pic(String market_pic) {
        this.market_pic = market_pic;
    }

    public String getMarket_short() {
        return market_short;
    }

    public void setMarket_short(String market_short) {
        this.market_short = market_short;
    }

    public Integer getShop_number() {
        return shop_number;
    }

    public void setShop_number(Integer shop_number) {
        this.shop_number = shop_number;
    }

    public MarketShowVo(){}
}
