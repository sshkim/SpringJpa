package com.sshkim.instagram.repository;

import com.sshkim.instagram.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sshkim on 2016. 8. 26..
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
