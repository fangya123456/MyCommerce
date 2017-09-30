package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ya.fang on 2017/9/18.
 */
public class MarketDetailInfoVo extends MarketInfoVo implements Serializable{

    private List<MarketTagVo> marketTags;                         //商场tag列表

    private List<MarketWifiVo> marketWifis;                       //商场wifi列表

    private List<MarketOfficeHoursVo> listMarketOfficeHours;      //商场开放时间列表

    private List<MarketSpecialGoodsVo> listMarketSpecialGoods;    //

    private List<MarketSpecialityGoodsVo> listMarketSpecialityGoods;   //特色商品列表

    public List<MarketTagVo> getMarketTags() {
        return marketTags;
    }

    public void setMarketTags(List<MarketTagVo> marketTags) {
        this.marketTags = marketTags;
    }

    public List<MarketWifiVo> getMarketWifis() {
        return marketWifis;
    }

    public void setMarketWifis(List<MarketWifiVo> marketWifis) {
        this.marketWifis = marketWifis;
    }

    public List<MarketOfficeHoursVo> getListMarketOfficeHours() {
        return listMarketOfficeHours;
    }

    public void setListMarketOfficeHours(List<MarketOfficeHoursVo> listMarketOfficeHours) {
        this.listMarketOfficeHours = listMarketOfficeHours;
    }

    public List<MarketSpecialGoodsVo> getListMarketSpecialGoods() {
        return listMarketSpecialGoods;
    }

    public void setListMarketSpecialGoods(List<MarketSpecialGoodsVo> listMarketSpecialGoods) {
        this.listMarketSpecialGoods = listMarketSpecialGoods;
    }

    public List<MarketSpecialityGoodsVo> getListMarketSpecialityGoods() {
        return listMarketSpecialityGoods;
    }

    public void setListMarketSpecialityGoods(List<MarketSpecialityGoodsVo> listMarketSpecialityGoods) {
        this.listMarketSpecialityGoods = listMarketSpecialityGoods;
    }

    public MarketDetailInfoVo(){}
}
