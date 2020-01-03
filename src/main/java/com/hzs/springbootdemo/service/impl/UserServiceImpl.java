package com.hzs.springbootdemo.service.impl;

import com.hzs.springbootdemo.dao.UserRepository;
import com.hzs.springbootdemo.domain.User;
import com.hzs.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * userService
 *
 * @author hezhensheng3
 * @date 2020-01-02 16:12
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * user持久层操作
     */
    @Resource
    private UserRepository userRepository;

    @Override
    public User getUser() {
        return getUserMock();
    }

    @Override
    public User findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        return user;
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
