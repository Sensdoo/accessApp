package com.sens.try001.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sensible on 22.10.2017.
 */

@Entity
@Table(name = "hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Getter
    @Setter
    private Long id;

    @ManyToMany
    @JoinTable(name = "contact_hobby_connector",
               joinColumns = @JoinColumn(name = "HOBBY_ID"),
               inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    private Set<Contact> contacts;

    public Set<Contact> getContacts() {
        if (contacts == null) contacts = new HashSet<>();
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Hobby{"  + id +
                '}';
    }
}
