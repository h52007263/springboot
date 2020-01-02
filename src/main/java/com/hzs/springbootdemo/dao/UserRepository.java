package com.hzs.springbootdemo.dao;

import com.hzs.springbootdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2020-01-02 16:53
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    User findByUserNameOrEmail(String username, String email);
}
