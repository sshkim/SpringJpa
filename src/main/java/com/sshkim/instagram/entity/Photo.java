package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sshkim on 2016. 10. 5..
 */
@Entity
@Table(name="photo")
@Data
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private Enum type;

    @Column(nullable = false)
    private Date create_date;

    @Column(nullable = false)
    private Date update_date;

    @Column(nullable = false)
    private Long type_id;
}
