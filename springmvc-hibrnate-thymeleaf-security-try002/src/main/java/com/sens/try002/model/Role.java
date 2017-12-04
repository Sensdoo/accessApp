package com.sens.try002.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Sensible on 29.11.2017.
 */

@Entity
@Table(name = "role")
@NamedQueries( {
        @NamedQuery(name = "Role.findByName",
                query = "select distinct r from Role r where r.name = :name"),
//        @NamedQuery(name = "Role.findByNameWithPrivileges",
//                query = "select distinct r from Role r left join fetch r.privileges p where  r.name = :name")
})
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

//    @ManyToMany
//    @JoinTable(name = "roles_privileges",
//               joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//               inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

//    public Collection<Privilege> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(Collection<Privilege> privileges) {
//        this.privileges = privileges;
//    }
}
