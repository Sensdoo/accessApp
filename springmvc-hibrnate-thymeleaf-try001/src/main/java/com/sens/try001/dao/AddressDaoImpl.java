package com.sens.try001.dao;

import com.google.common.collect.Lists;
import com.sens.try001.dao.interfaces.AddressDao;
import com.sens.try001.model.Address;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {

    private Log LOG = LogFactory.getLog(AddressDaoImpl.class);

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    @Override
    public void save(Address address) {
        entityManager.merge(address);
    }

    @Override
    public List<Address> findAll() {
        return entityManager.createNamedQuery("Address.FindAll").getResultList();
    }

    @Override
    public Address findById(long id) {
        TypedQuery<Address> query =
                entityManager.createNamedQuery("Address.findById", Address.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Address findByIdWithEntrances(long id) {
        TypedQuery<Address> query = entityManager.createNamedQuery("Address.findByIdWithEntrances", Address.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
