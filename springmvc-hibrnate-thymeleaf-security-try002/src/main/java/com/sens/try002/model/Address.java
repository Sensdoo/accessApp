package com.sens.try002.model;

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
        @NamedQuery(name = "Address.findAll", query = "select a from Address a"),
//        @NamedQuery(name = "Address.findByIdWithEntrances",
//                query = "select distinct a from Address a left join fetch a.entrances e where a.id = :id")
})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Street street;

    @Column(name = "house")
    private int house;

    @Column(name = "BUILDING")
    private int building;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrance> entrances = new ArrayList<>();

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

//    public List<Entrance> getEntrances() {
//        return entrances;
//    }
//
//    public void setEntrances(List<Entrance> entrances) {
//        this.entrances = entrances;
//    }
//
//    public void addEntrance(Entrance entrance) {
//        entrance.setAddress(this);
//        this.entrances.add(entrance);
//    }
//
//    public void removeEntrance(Entrance entrance) {
//        this.entrances.remove(entrance);
//    }

    @Override
    public String toString() {
        return "Address{" +
                "Street: '" + street.getName() + '\'' +
                ", house: " + house +
                ", building: " + building +
                '}';
    }
}
