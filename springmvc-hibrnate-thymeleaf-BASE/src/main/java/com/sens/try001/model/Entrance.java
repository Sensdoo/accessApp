package com.sens.try001.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */

@Entity
@Table(name = "entrance")
public class Entrance {

    private long id;
    private int number;
    private String access;
    private List<Comment> commentList = new ArrayList<>();
    private Address address;

    public Entrance() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NUMBER")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Column(name = "ACCESS")
    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @OneToMany(mappedBy = "entrance", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "entrance: " + number;
    }
}
