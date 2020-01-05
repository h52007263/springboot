package com.hzs.springbootdemo.dao.user;

import com.alibaba.fastjson.JSON;
import com.hzs.springbootdemo.dao.UserRepository;
import com.hzs.springbootdemo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2020-01-02 17:02
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Resource
    private UserRepository userRepository;

    /**
     * 增加用户测试
     */
    @Transactional
    @Test
    public void addUserTest() {
        userRepository.save(new User("a01", "a01", "a01", "a01","2020-1-1"));
        System.out.println("增加成功");
    }

    @Test
    public void updateUserTest() {
     User user = userRepository.findByUserName("aa1");
     log.info("UserRepositoryTest -> updateUserTest end, user={}", JSON.toJSONString(user));
    }


    @Test
    public void test() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

        Assert.assertEquals(5, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com"));
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
