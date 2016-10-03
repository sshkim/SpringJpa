package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sshkim on 2016. 8. 26..
 */

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private Date create_date;

    @Column
    private Date update_date;

    @PrePersist
    public void setCreateDate(){
        Date date = new Date();
        this.create_date = date;
        this.update_date = date;
    }

}
