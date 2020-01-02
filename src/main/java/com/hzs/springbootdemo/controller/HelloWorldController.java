package com.hzs.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hzs.springbootdemo.domain.User;
import com.hzs.springbootdemo.properties.NeoProperties;
import com.hzs.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * HelloWorld控制类
 *
 * @author hezhensheng3
 * @date 2020-01-02 15:56
 **/
// json格式输出
@RestController
public class HelloWorldController {
    @Value("${com.neo.title}")
    private String demo;

    Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private UserService userService;

    /**
     * hello
     * @return
     */
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    /**
     * 获取用户
     * @return
     */
    @RequestMapping("/getUser")
    public User getUser() {
        User user = userService.getUser();
        log.info("HelloWorldController -> getUser end, demo={}", JSON.toJSONString(demo));
        return user;
    }

}
