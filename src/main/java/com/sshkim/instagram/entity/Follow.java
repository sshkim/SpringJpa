package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sshkim on 2016. 10. 17..
 */
@Entity
@Table(name = "follow")
@Data
public class Follow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long follow_id;
}
