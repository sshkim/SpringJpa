package com.sshkim.instagram.service;

import com.sshkim.instagram.entity.User;

/**
 * Created by sshkim on 2016. 9. 10..
 */
public interface UserService {

    User create(User user);

    User findOneById(Long id);
}
