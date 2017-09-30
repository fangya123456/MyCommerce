package com.fy.commerce.utils;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by ya.fang on 2017/9/15.
 */
public class JsonResult<T> implements Serializable {

    @ApiModelProperty(value = "结果代码")
    private int code;
    @ApiModelProperty(value = "结果异常信息")
    private String message;
    @ApiModelProperty(value = "结果对象")
    private T dataMap;
    @ApiModelProperty(value = "结果")
    private boolean ok = true;

    public JsonResult(int code, String message, T dataMap) {
        this.code = code;
        this.ok = code == 200;
        this.message = message;
        this.dataMap = dataMap;
    }



    public JsonResult(int code, T dataMap) {
        this.code = code;
        this.ok = code == 200;
        this.dataMap = dataMap;
    }

    public JsonResult(T dataMap) {
        this.dataMap = dataMap;
    }

    public JsonResult() {}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.ok = code == 200;
    }

    public boolean getOk(){
        return ok;
    }
    public void setOk(boolean ok){
        this.ok = ok;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDataMap() {
        return dataMap;
    }

    public void setDataMap(T dataMap) {
        this.dataMap = dataMap;
    }
}
