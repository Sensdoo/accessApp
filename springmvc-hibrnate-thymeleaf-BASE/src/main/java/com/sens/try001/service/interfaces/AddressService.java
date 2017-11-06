package com.sens.try001.service.interfaces;

import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;

import java.util.List;

/**
 * Created by Sensible on 24.10.2017.
 */
public interface AddressService {

    void save(Address address);
    List<Address> findAll();
    Address findById(long id);
    Address findByIdWithEntrances(long id);
}
