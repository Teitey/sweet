package com.sweet.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by xc-sw on 2017/8/1.
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String userName;
    private Integer age;
    private String sex;
    private Integer statusUnable;
    private Integer statusEnable;

    public Integer getStatusUnable() {
        return statusUnable;
    }

    public void setStatusUnable(Integer statusUnable) {
        this.statusUnable = statusUnable;
    }

    public Integer getStatusEnable() {
        return statusEnable;
    }

    public void setStatusEnable(Integer statusEnable) {
        this.statusEnable = statusEnable;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
