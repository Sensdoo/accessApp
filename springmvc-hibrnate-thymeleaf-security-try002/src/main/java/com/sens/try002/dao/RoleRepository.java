package com.sens.try002.dao;

import com.sens.try002.model.Role;

/**
 * Created by Engineers on 04.12.2017.
 */
public interface RoleRepository {
    Role findByName(String roleName);
    Role save(Role role);
}
