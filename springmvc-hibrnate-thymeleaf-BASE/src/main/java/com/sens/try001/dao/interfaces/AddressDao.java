package com.sens.try001.dao.interfaces;

import com.sens.try001.model.Address;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

/**
 * Created by Sensible on 23.10.2017.
 */

@EnableJpaRepositories
public interface AddressDao {

    void save(Address address);
    List<Address> findAll();
    Address findById(long id);
    Address findByIdWithEntrances(long id);
}
