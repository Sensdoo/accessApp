package com.sens.try002.model;

import javax.persistence.*;

/**
 * Created by Sensible on 23.10.2017.
 */

@Entity
@Table(name = "comment")
//@NamedQueries({
//        @NamedQuery(name = "Comment.count", query = "select count(c) from Comment c")
//})
public class Comment {

    private long id;
    private String message;
    private Entrance entrance;

    public Comment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ManyToOne
    @JoinColumn(name = "ENTRANCE_ID")
    public Entrance getEntrance() {
        return entrance;
    }

    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }

    @Override
    public String toString() {
        return "comment: " + message + '\'' + '}';
    }
}
