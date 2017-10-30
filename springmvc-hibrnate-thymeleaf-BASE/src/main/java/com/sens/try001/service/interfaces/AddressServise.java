package com.sens.try001.service.interfaces;

import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;

import java.util.List;

/**
 * Created by Sensible on 24.10.2017.
 */
public interface AddressServise {

    Address save(Address address);
    List<Address> findAll();
    List<Address> findAllWithEntrances();
    Address findById(long id);
    void updateAddress(Address address);
    void updateAddress(long id, Entrance entrance);
}
