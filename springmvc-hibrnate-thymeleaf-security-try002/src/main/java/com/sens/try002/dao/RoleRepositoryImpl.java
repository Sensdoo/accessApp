package com.sens.try002.dao;

import com.sens.try002.model.Role;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Engineers on 04.12.2017.
 */

@Service
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    @Override
    public Role findByName(String roleName) {
        return entityManager.createNamedQuery("Role.findByName", Role.class)
                .setParameter("name", roleName).getSingleResult();
    }

    @Override
    public Role save(Role role) {
        entityManager.persist(role);
        return role;
    }
}
