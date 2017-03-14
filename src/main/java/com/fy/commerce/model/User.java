package com.fy.commerce.model;

import java.io.Serializable;

/**
 * Created by ya.fang on 2017/1/11.
 */
public class User implements Serializable{
    /**
     * uid 主键
     * */
    private Integer uid;

    /**
     * 用户名
     * */
    private String username;

    /**
     * 密码
     * */
    private String password;

    /**
     * 姓名
     * */
    private String name;

    /**
     * 性别
     * */
    private String sex;

    /**
     * 邮件
     * */
    private String email;

    /**
     * 电话
     * */
    private String phone;

    /**
     * birthday
     * */
    private String birthday;

    /**
     * 地址
     * */
    private String addr;

    /**
     * 激活状态
     * 1 启用 0 停用
     * */
    private Integer state;

    /**
     * 激活码
     * */
    private String code;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
