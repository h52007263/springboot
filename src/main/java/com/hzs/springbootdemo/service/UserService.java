package com.hzs.springbootdemo.service;

import com.hzs.springbootdemo.domain.User;
import com.hzs.springbootdemo.model.user.UserVO;

/**
 * userService接口
 *
 * @author hezhensheng3
 * @date 2020-01-02 16:12
 **/
public interface UserService {
    /**
     * 获取一个用户
     * @return
     */
    User getUser();

    /**
     * 根据username获取user
     * @param userName
     * @return
     */
    UserVO findByUserName(String userName);
}
