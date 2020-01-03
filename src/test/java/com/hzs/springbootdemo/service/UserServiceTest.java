package com.hzs.springbootdemo.service;

import com.alibaba.fastjson.JSON;
import com.hzs.springbootdemo.dao.user.UserRepositoryTest;
import com.hzs.springbootdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2020-01-03 9:15
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    private Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void findUserTest() {
        User user = userService.findByUserName("aa1");
        log.info("UserServiceTest -> findUserTest end, user={}", JSON.toJSONString(user));
    }

}
