package com.sens.try001.dao.interfaces;

import com.sens.try001.model.Address;

import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */
public interface AddressDao {

    Address save(Address address);
    List<Address> findAll();
    List<Address> findAllWithEntrances();
    Address findById(long id);
}
