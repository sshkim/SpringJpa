package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sshkim on 2016. 10. 5..
 */
@Entity
@Table(name="like")
@Data
public class Like {

    @Column(nullable = false)
    private Long document_id;

    @Column(nullable = false)
    private Long user_id;
}
