package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ya.fang on 2017/9/16.
 */
public class MarketSpecialGoodsVo implements Serializable {

    private Long id;
    private Long marketId;
    private Long psgId;
    private Integer orderBy;             //排序类型
    private Integer deleteStatus;        //删除状态
    private Long createDate;             //创建日期
    private String createOperator;       //创建人工号
    private Long updateDate;             //修改日期
    private String updateOperator;       //修改人工号

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

    public Long getPsgId() {
        return psgId;
    }

    public void setPsgId(Long psgId) {
        this.psgId = psgId;
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

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator;
    }

    public MarketSpecialGoodsVo(){}
}
