package com.fy.commerce.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by ya.fang on 2017/1/11.
 */
@ApiModel(value = "Rest result", description = "请求结果")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4696898674758059398L;

    @ApiModelProperty(value = "结果代码")
    private int code;
    @ApiModelProperty(value = "结果异常信息")
    private String message;
    @ApiModelProperty(value = "结果对象")
    private T data;
    @ApiModelProperty(value = "结果")
    private boolean ok = true;

    public Result(int code, String message, T data) {
        this.code = code;
        this.ok = code == 200;
        this.message = message;
        this.data = data;
    }



    public Result(int code, T data) {
        this.code = code;
        this.ok = code == 200;
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result() {}

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
