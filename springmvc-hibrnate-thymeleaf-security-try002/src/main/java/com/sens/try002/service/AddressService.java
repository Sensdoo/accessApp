package com.sens.try002.service;

import com.sens.try002.model.Address;

import java.util.List;

/**
 * Created by Sensible on 05.12.2017.
 */

public interface AddressService {
    List<Address> findAll();
    List<Address> findAllByStreetName(String streetName);
    Address findById(Long id);
}