package com.example.spring.exercise.domain;

import org.springframework.jdbc.core.RowMapper;

public class User {
    private String userId;
    private String userName;
    private String age;
    private String birthday;

    public String getBirthday() {
        return birthday;
    }
    public String getUserName() {
        return userName;
    }
    public String getAge() {
        return age;
    }
    public String getUserId() {
        return userId;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setAge(String age) {
        this.age = age;
    }

}
