package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sshkim on 2016. 10. 5..
 */
@Entity
@Table(name = "like")
@Data
public class Like implements Serializable {

    @Column(nullable = false)
    private Long document_id;

    @Column(nullable = false)
    private Long user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;
}
