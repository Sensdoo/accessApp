package com.sens.try002.service;

import com.sens.try002.dao.AddressRepository;
import com.sens.try002.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sensible on 05.12.2017.
 */

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> findAllByStreetName(String streetName) {
        return addressRepository.findAllByStreetName(streetName);
    }

    @Override
    @Transactional(readOnly = true)
    public Address findById(Long id) {
        return addressRepository.findById(id);
    }
}
