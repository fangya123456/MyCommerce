package com.fy.commerce.vo.market;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ya.fang on 2017/9/14.
 */
public class MarketShowListVo implements Serializable {

    List<MarketShowVo> data;  //商场展示列表
    private Integer totalCount;   //商场总数
    private String type;          //商场类型

    public List<MarketShowVo> getData() {
        return data;
    }

    public void setData(List<MarketShowVo> data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MarketShowListVo(){}
}
