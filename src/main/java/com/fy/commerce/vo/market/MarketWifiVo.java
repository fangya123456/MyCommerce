package com.fy.commerce.vo.market;

import java.io.Serializable;

/**
 * Created by ya.fang on 2017/9/15.
 */
public class MarketWifiVo implements Serializable {

    private Long id;               //主键ID
    private Long marketId;         //商场ID
    private String wifiName;       //wifi名称
    private String wifiPsd;        //wifiPsd

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getWifiPsd() {
        return wifiPsd;
    }

    public void setWifiPsd(String wifiPsd) {
        this.wifiPsd = wifiPsd;
    }

    public MarketWifiVo(){}
}
