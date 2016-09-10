package com.sshkim.instagram.service;

import com.sshkim.instagram.entity.User;
import com.sshkim.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sshkim on 2016. 9. 10..
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }


}
