package com.sens.try002.model;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "street", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
