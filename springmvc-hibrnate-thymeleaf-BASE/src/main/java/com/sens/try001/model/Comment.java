package com.sens.try001.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ENTRANCE_ID")
    private Entrance entrance;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "user_comment_connector",
            joinColumns = @JoinColumn(name = "COMMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private List<User> userList;

    public Comment() {
    }

    @Override
    public String toString() {
        return "comment: " + message + '\'' + '}';
    }
}
