package com.sens.try002.dao;

import com.sens.try002.model.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Sensible on 27.11.2017.
 */

@Repository("addressDao")
public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    public List<Address> findAll() {
        return entityManager.createNamedQuery("Address.findAll").getResultList();
    }

    @Override
    public List<Address> findAllByStreetName(String streetName) {
        return entityManager.createNamedQuery("Address.findAllByStreetName")
                .setParameter("name", streetName).getResultList();
    }

    @Override
    public Address findById(Long id) {
        return entityManager.createNamedQuery("Address.findById", Address.class)
                .setParameter("id", id).getSingleResult();
    }

}
