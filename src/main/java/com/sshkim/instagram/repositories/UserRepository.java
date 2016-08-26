package com.sshkim.instagram.repositories;

import com.sshkim.instagram.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sshkim on 2016. 8. 26..
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
}
