package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sshkim on 2016. 10. 5..
 */
@Entity
@Table(name = "message")
@Data
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Enum type;

    @Column(nullable = false)
    private Date create_date;

    @Column(nullable = false)
    private Date update_date;

    @Column(nullable = false)
    private Long type_id;

    @Column(nullable = false)
    private Long user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "type_id")
    private Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "type_id")
    private Comment comment;

    // TODO!! Type 관계 형성

}
