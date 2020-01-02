package com.hzs.springbootdemo.service.impl;

import com.hzs.springbootdemo.domain.User;
import com.hzs.springbootdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2020-01-02 16:12
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return getUserMock();
    }

    /**
     * 获取一个用户的mock方法
     * @return
     */
    private User getUserMock() {
        User user = new User();
        user.setUserName("小一");
        user.setPassword("1234");
        return user;
    }
}
