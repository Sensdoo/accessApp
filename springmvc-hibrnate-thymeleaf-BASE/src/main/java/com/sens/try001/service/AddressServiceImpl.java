package com.sens.try001.service;

import com.sens.try001.dao.interfaces.AddressDao;
import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.AddressServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sensible on 24.10.2017.
 */

@Service
public class AddressServiceImpl implements AddressServise {


    @Autowired
    private AddressDao addressDao;

    @Override
    @Transactional
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Override
    @Transactional
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    @Transactional
    public List<Address> findAllWithEntrances() {
        return addressDao.findAllWithEntrances();
    }

    @Override
    @Transactional
    public Address findById(long id) {
        return addressDao.findById(id);
    }

    @Override
    @Transactional
    public void updateAddress(Address address) {
        Address updateAddress = addressDao.findById(address.getId());
        if (updateAddress != null) {
            updateAddress.setStreet(address.getStreet());
            updateAddress.setHouse(address.getHouse());
            updateAddress.setBuilding(address.getBuilding());
            updateAddress.setEntranceSet(address.getEntranceSet());
        }
    }

    @Override
    @Transactional
    public void updateAddress(long id, Entrance entrance) {
        Address address = addressDao.findById(id);
        entrance.setAddress(address);
        address.addEntrance(entrance);
        updateAddress(address);
    }
}
