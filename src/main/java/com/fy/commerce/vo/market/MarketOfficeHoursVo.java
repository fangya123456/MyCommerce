package com.fy.commerce.vo.market;

import java.io.Serializable;

/**
 * Created by ya.fang on 2017/9/15.
 */
public class MarketOfficeHoursVo implements Serializable{

    private static final String[] num_lower = { "一", "二", "三", "四", "五", "六", "日",};

    private Long id;             //主键ID
    private Long marketId;       //商场ID
    private Integer startDay;    //开始工作日
    private String officeStartDay; //
    private Integer endDay;      //结束工作日
    private String officeEndDay; //
    private String startTime;    //工作日开始时间
    private String endTime;      //工作日结束时间

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

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public String getOfficeStartDay() {
        if (startDay != null && startDay > 0 && startDay < 8){
            officeStartDay = "周" + num_lower[startDay-1];
        }
        return officeStartDay;
    }

    public void setOfficeStartDay(String officeStartDay) {
        this.officeStartDay = officeStartDay;
    }

    public Integer getEndDay() {
        return endDay;
    }

    public void setEndDay(Integer endDay) {
        this.endDay = endDay;
    }

    public String getOfficeEndDay() {
        if (endDay != null && endDay > startDay-1 && endDay < 8){
            officeEndDay = "周" + num_lower[endDay-1];
        }
        return officeEndDay;
    }

    public void setOfficeEndDay(String officeEndDay) {
        this.officeEndDay = officeEndDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public MarketOfficeHoursVo(){}
}
