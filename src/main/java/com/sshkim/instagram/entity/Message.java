package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sshkim on 2016. 10. 5..
 */
@Entity
@Table(name="message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date create_date;

    @Column(nullable = false)

    private Date update_date;
    @Column(nullable = false)

    private Long document_id;

    @Column(nullable = false)
    private Long from_user_id;

    @Column(nullable = false)
    private Long to_user_id;
}
