package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ya.fang on 2017/9/15.
 */
public class ReceiverInfoVo implements Serializable{

    private Long id;
    private String operatorId;
    private Integer platformType;
    private Integer thumbsUp;
    private Integer storeUp;
    private String infoId;
    private String infoName;
    private Integer infoType;
    private Date thumbsUpTime;
    private Date storeUpTime;
    private Date firstTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public Integer getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(Integer thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public Integer getStoreUp() {
        return storeUp;
    }

    public void setStoreUp(Integer storeUp) {
        this.storeUp = storeUp;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }

    public Date getThumbsUpTime() {
        return thumbsUpTime;
    }

    public void setThumbsUpTime(Date thumbsUpTime) {
        this.thumbsUpTime = thumbsUpTime;
    }

    public Date getStoreUpTime() {
        return storeUpTime;
    }

    public void setStoreUpTime(Date storeUpTime) {
        this.storeUpTime = storeUpTime;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public ReceiverInfoVo(){}
}
