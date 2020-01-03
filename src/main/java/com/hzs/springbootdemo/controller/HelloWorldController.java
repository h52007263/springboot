package com.hzs.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hzs.springbootdemo.domain.User;
import com.hzs.springbootdemo.model.user.UserQuery;
import com.hzs.springbootdemo.properties.NeoProperties;
import com.hzs.springbootdemo.response.Result;
import com.hzs.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * HelloWorld控制类
 *
 * @author hezhensheng3
 * @date 2020-01-02 15:56
 **/
// json格式输出
@RestController
public class HelloWorldController {
    /**
     * 日志
     */
    Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    /**
     * userService对象
     */
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
    @PostMapping("/getUser")
    @ResponseBody
    public Result<User> getUser(@RequestBody UserQuery userQuery) {
        log.info("HelloWorldController -> getUser start, username={}", JSON.toJSONString(userQuery));
        if (StringUtils.isEmpty(userQuery.getUserName())) {
            return Result.buildFailResult(1, "username为空");
        }
        User user = userService.findByUserName(userQuery.getUserName());
        log.info("HelloWorldController -> getUser end, userQuery={}, user={}", JSON.toJSONString(userQuery),
                JSON.toJSONString(user));
        List<User> userList = new ArrayList<>();
        userList.add(user);
        log.info("HelloWorldController -> getUser end, userList={}", JSON.toJSONString(userList));
        return Result.buildSuccessResult(userList);
    }

}
