package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ya.fang on 2017/9/15.
 * 商场tag列表
 */
public class MarketTagVo implements Serializable{

    private Long tagId;
    private Long marketId;               //商场Id
    private String tagName;              //tag名称
    private String tagSketch;            //tag简述
    private String tagSpecification;     //tag详述
    private Integer orderBy;             //排序类型
    private Integer deleteStatus;        //删除状态
    private Date createDate;             //创建日期
    private String createOperator;       //创建人工号
    private Date updateDate;             //修改日期
    private String updateOperator;       //修改人工号

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagSketch() {
        return tagSketch;
    }

    public void setTagSketch(String tagSketch) {
        this.tagSketch = tagSketch;
    }

    public String getTagSpecification() {
        return tagSpecification;
    }

    public void setTagSpecification(String tagSpecification) {
        this.tagSpecification = tagSpecification;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator;
    }

    public MarketTagVo(){}
}
