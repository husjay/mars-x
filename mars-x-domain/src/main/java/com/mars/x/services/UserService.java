package com.mars.x.services;

import com.mars.x.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUserById(Integer id) {

        User user = new User();
        user.setId(1);
        user.setName("eric");

        return user;
    }

}
