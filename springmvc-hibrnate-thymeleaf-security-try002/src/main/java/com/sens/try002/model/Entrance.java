package com.sens.try002.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */

@Entity
@Table(name = "entrance")
//@NamedQueries( {
//        @NamedQuery(name = "Entrance.findAll", query = "select e from Entrance e"),
//        @NamedQuery(name = "Entrance.findById", query = "select distinct e from Entrance e where e.id = :id"),
//        @NamedQuery(name = "Entrance.count", query = "select count(e) from Entrance e"),
//        @NamedQuery(name = "Entrance.findByIdWithComments",
//                query = "select e from Entrance e left join fetch e.comments c where e.id = :id")
//})
public class Entrance {

    private long id;
    private int number;
    private String access;
    private Address address;
    private List<Comment> comments = new ArrayList<>();

    public Entrance() {
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

    @ManyToOne
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "entrance", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comment.setEntrance(this);
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    @Override
    public String toString() {
        return "entrance: " + number;
    }
}
