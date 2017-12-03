package com.sens.try001.service;

import com.sens.try001.dao.interfaces.AddressDao;
import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sensible on 24.10.2017.
 */

@Service
@Transactional
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressDao addressDao;

    @Override
    @Transactional
    public void save(Address address) {
        addressDao.save(address);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Address findById(long id) {
        return addressDao.findById(id);
    }

    @Override
    public Address findByIdWithEntrances(long id) {
        return addressDao.findByIdWithEntrances(id);
    }

}
