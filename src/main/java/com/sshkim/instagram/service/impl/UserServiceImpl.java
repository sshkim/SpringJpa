package com.sshkim.instagram.service.impl;

import com.sshkim.instagram.entity.User;
import com.sshkim.instagram.repository.UserRepository;
import com.sshkim.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sshkim on 2016. 9. 12..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOneById(Long id) {
        return userRepository.findOne(id);
    }
}
