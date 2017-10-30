package com.sens.try001.dao;

import com.sens.try001.dao.interfaces.AddressDao;
import com.sens.try001.model.Address;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */

@Repository
public class AddressDaoImpl implements AddressDao {

    private Log LOG = LogFactory.getLog(AddressDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Address save(Address address) {
        if (address != null) {
            getSession().saveOrUpdate(address);
            LOG.info("Address saved: " + address);
        }
        return address;
    }

    @Override
    public List<Address> findAll() {
        return getSession().createQuery("select a from Address a").list();
    }

    @Override
    public List<Address> findAllWithEntrances() {
        return getSession().createNamedQuery("Address.findAllWithEntrances").list();
    }

    @Override
    public Address findById(long id) {
        return (Address) getSession().createNamedQuery("Address.findById").setParameter("id", id).uniqueResult();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
