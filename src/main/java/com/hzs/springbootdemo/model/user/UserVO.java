package com.hzs.springbootdemo.model.user;

/**
 * UserVO
 *
 * @author hezhensheng3
 * @date 2020-01-02 16:10
 **/
public class UserVO {
    private String userName;
    private String password;
    private String email;
    private String nickName;
    private String regTime;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
}
