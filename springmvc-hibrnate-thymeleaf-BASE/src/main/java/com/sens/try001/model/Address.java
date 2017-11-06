package com.sens.try001.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sensible on 23.10.2017.
 */

@Entity
@Table(name = "address")
@NamedQueries( {
        @NamedQuery(name = "Address.findById",
                query = "select distinct a from Address a where a.id = :id"),
        @NamedQuery(name = "Address.FindAll", query = "select a from Address a"),
        @NamedQuery(name = "Address.findByIdWithEntrances",
                query = "select distinct a from Address a left join fetch a.entrances e where a.id = :id")
})
public class Address {


    private long id;
    private String Street;
    private int house;
    private int building;
    private int version;
    private Set<Entrance> entrances = new HashSet<>();

    public Address() {
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

    @Column(name = "STREET")
    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    @Column(name = "HOUSE")
    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Column(name = "BUILDING")
    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Entrance> getEntrances() {
        return entrances;
    }

    public void setEntrances(Set<Entrance> entrances) {
        this.entrances = entrances;
    }

    public void addEntrance(Entrance entrance) {
        entrance.setAddress(this);
        this.entrances.add(entrance);
    }

    public void removeEntrance(Entrance entrance) {
        this.entrances.remove(entrance);
    }

    @Override
    public String toString() {
        return "Address{" +
                "Street: '" + Street + '\'' +
                ", house: " + house +
                ", building: " + building +
                '}';
    }
}
