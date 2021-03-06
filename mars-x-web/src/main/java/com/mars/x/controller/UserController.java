package com.mars.x.controller;

import com.mars.x.User;
import com.mars.x.annotation.XRetryable;
import com.mars.x.retry.SpringRetry;
import com.mars.x.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SpringRetry springRetry;

    @XRetryable(value = RuntimeException.class, maxAttempts = 3)
    @RequestMapping("user/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        springRetry.call();
        return userService.findUserById(id);
    }

}
