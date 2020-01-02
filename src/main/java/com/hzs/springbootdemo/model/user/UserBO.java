package com.hzs.springbootdemo.model.user;

/**
 * UserBO 业务对象
 *
 * @author hezhensheng3
 * @date 2020-01-02 16:09
 **/
public class UserBO {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
