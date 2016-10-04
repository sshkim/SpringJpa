package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sshkim on 2016. 10. 5..
 */
@Entity
@Table(name="comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String memo;

    @Column(nullable = false)
    private Date create_date;

    @Column(nullable = false)
    private Date update_date;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long document_id;
}
