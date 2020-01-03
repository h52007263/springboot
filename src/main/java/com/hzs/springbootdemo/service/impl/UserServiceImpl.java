package com.hzs.springbootdemo.service.impl;

import com.hzs.springbootdemo.dao.UserRepository;
import com.hzs.springbootdemo.domain.User;
import com.hzs.springbootdemo.model.user.UserVO;
import com.hzs.springbootdemo.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
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
    public UserVO findByUserName(String userName) {
        try {
            User user = userRepository.findByUserName(userName);
            UserVO userVO = convertVO(user);
            return userVO;
        } catch (Exception e) {
            throw new RuntimeException("service发生异常");
        }
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

    private UserVO convertVO(User user) {
        UserVO userVO = new UserVO();
        if (user == null) {
            return userVO;
        }
        if (user.getEmail() != null) {
            userVO.setEmail(user.getEmail());
        }
        if (user.getUserName() != null) {
            userVO.setUserName(user.getUserName());
        }
        if (user.getNickName() != null) {
            userVO.setNickName(user.getNickName());
        }
        if (user.getPassword() != null) {
            userVO.setPassword(user.getPassword());
        }
        if (user.getRegTime() != null) {
            userVO.setRegTime(user.getRegTime());
        }
        return userVO;
    }

}
