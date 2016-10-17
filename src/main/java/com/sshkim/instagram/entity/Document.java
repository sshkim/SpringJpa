package com.sshkim.instagram.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by sshkim on 2016. 10. 5..
 */
@Entity
@Table(name = "document")
@Data
public class Document implements Serializable, Component {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Optional<String> memo;

    @Column(nullable = false)
    private Long view_cnt;

    @Column(nullable = false)
    private Date create_date;

    @Column(nullable = false)
    private Date update_date;

    @Column(nullable = false)
    private Long user_id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "document")
    private Message message;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document")
    private List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document")
    private List<Photo> photoList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document")
    private List<Comment> commentList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "document_tag", joinColumns = @JoinColumn(name = "document_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<Tag> tagList;


}
