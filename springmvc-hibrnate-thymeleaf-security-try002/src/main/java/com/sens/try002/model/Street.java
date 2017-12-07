package com.sens.try002.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Engineers on 04.12.2017.
 */

@Entity
@Table(name = "street")
public class Street {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Street() {
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
