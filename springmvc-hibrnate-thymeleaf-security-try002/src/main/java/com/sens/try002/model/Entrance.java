package com.sens.try002.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */

@Entity
@Table(name = "entrance")
@NamedQueries( {
        @NamedQuery(name = "Entrance.count", query = "select count(e) from Entrance e"),
        @NamedQuery(name = "Entrance.findAll", query = "select e from Entrance e"),
        @NamedQuery(name = "Entrance.findById", query = "select distinct e from Entrance e where e.id = :id"),
        @NamedQuery(name = "Entrance.findByNumber", query = "select distinct e from Entrance e where e.number = :number"),
        @NamedQuery(name = "Entrance.findByIdWithComments",
                query = "select e from Entrance e left join fetch e.comments c where e.id = :id")
})
public class Entrance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Min(value = 1, message = "Не может быть меньше 1")
    @Max(value = 2000, message = "Не может быть больше 15")
    @Column(name = "NUMBER")
    private int number;

    @NotNull
    @NotBlank(message = "поле не может быть пустым")
    @Column(name = "ACCESS")
    private String access;

    @NotNull
    @Min(value = 1, message = "Не может быть меньше 1")
    @Max(value = 2000, message = "Не может быть больше 2000")
    @Column(name = "KEY_NUMBER")
    private int key;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "entrance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Entrance() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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
