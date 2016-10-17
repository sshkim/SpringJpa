package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by sshkim on 2016. 8. 26..
 */

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Date create_date;

    @Column(nullable = false)
    private Date update_date;

    // 탈퇴 일자
//    @Column(nullable = false)
//    private Date drop_date;

    // 탈퇴 유무
//    private int status;

    // 사용하는 언어(Global Service)
//    private String language;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Like> likeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Document> documentList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> commentList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Photo> photoList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Component> messageList;


    @OneToMany
    @JoinTable(name = "follow", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "follow_id", referencedColumnName = "id"))
    private List<User> getFollowers;

    @OneToMany
    @JoinTable(name = "follow", joinColumns = @JoinColumn(name = "follow_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> getFollows;


    @PrePersist
    public void setCreateDate() {
        Date date = new Date();
        this.create_date = date;
        this.update_date = date;
    }

}
