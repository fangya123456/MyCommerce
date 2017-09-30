package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ya.fang on 2017/9/18.
 */
public class MarketInfoVo implements Serializable {

    private Long id;
    private Long idUuid;
    private String marketNumber;
    private String marketName;
    private Integer firstOrgId;
    private Integer secondOrgId;
    private String firstOrgName;
    private String secondOrgName;
    private String provinceId;
    private String prvinceName;
    private String cityId;
    private String cityName;
    private Long districtId;
    private String marketAddress;
    private String marketShort;
    private String marketStamp;
    private String marketPic;
    private String lon;             //经度
    private String lat;             //纬度
    private Integer carport;        //车位数量
    private String openingHours;    //开放时间
    private String outMarketId;
    private BigDecimal distance;
    private Integer isDel;
    private Long createDate;         //毫秒数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUuid() {
        return idUuid;
    }

    public void setIdUuid(Long idUuid) {
        this.idUuid = idUuid;
    }

    public String getMarketNumber() {
        return marketNumber;
    }

    public void setMarketNumber(String marketNumber) {
        this.marketNumber = marketNumber;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Integer getFirstOrgId() {
        return firstOrgId;
    }

    public void setFirstOrgId(Integer firstOrgId) {
        this.firstOrgId = firstOrgId;
    }

    public Integer getSecondOrgId() {
        return secondOrgId;
    }

    public void setSecondOrgId(Integer secondOrgId) {
        this.secondOrgId = secondOrgId;
    }

    public String getFirstOrgName() {
        return firstOrgName;
    }

    public void setFirstOrgName(String firstOrgName) {
        this.firstOrgName = firstOrgName;
    }

    public String getSecondOrgName() {
        return secondOrgName;
    }

    public void setSecondOrgName(String secondOrgName) {
        this.secondOrgName = secondOrgName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getPrvinceName() {
        return prvinceName;
    }

    public void setPrvinceName(String prvinceName) {
        this.prvinceName = prvinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getMarketAddress() {
        return marketAddress;
    }

    public void setMarketAddress(String marketAddress) {
        this.marketAddress = marketAddress;
    }

    public String getMarketShort() {
        return marketShort;
    }

    public void setMarketShort(String marketShort) {
        this.marketShort = marketShort;
    }

    public String getMarketStamp() {
        return marketStamp;
    }

    public void setMarketStamp(String marketStamp) {
        this.marketStamp = marketStamp;
    }

    public String getMarketPic() {
        return marketPic;
    }

    public void setMarketPic(String marketPic) {
        this.marketPic = marketPic;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getCarport() {
        return carport;
    }

    public void setCarport(Integer carport) {
        this.carport = carport;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getOutMarketId() {
        return outMarketId;
    }

    public void setOutMarketId(String outMarketId) {
        this.outMarketId = outMarketId;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public MarketInfoVo(){}
}
