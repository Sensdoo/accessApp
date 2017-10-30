package com.sens.try001.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by momo on 21.10.2017.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Setter
    @Getter
    private String login;

    @Setter
    @Getter
    private String password;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "user_comment_connector",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMMENT_ID"))
    private List<Comment> commentList;

    public User() {}
}
