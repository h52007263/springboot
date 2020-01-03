package com.hzs.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hzs.springbootdemo.domain.User;
import com.hzs.springbootdemo.model.user.UserQuery;
import com.hzs.springbootdemo.config.response.Result;
import com.hzs.springbootdemo.model.user.UserVO;
import com.hzs.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
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
    @PostMapping("/get")
    @ResponseBody
    public Result<UserVO> getUser(@RequestBody UserQuery userQuery) {
        // 1.入参判断
        log.info("HelloWorldController -> getUser start, username={}", JSON.toJSONString(userQuery));
        if (StringUtils.isEmpty(userQuery.getUserName())) {
            return Result.buildFailResult(1, "username为空");
        }

        // 2.调用service
        UserVO user = userService.findByUserName(userQuery.getUserName());

        // 3.拼装返回结果
        List<UserVO> userList = new ArrayList<>();
        userList.add(user);
        log.info("HelloWorldController -> getUser end, userList={}", JSON.toJSONString(userList));
        return Result.buildSuccessResult(userList);
    }

}
