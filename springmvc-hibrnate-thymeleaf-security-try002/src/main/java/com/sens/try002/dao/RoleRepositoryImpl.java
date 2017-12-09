package com.sens.try002.dao;

import com.sens.try002.model.Role;
import com.sens.try002.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by Engineers on 04.12.2017.
 */

@Service
public class RoleRepositoryImpl implements RoleRepository {

    private Log LOG = LogFactory.getLog(RoleRepository.class);

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    @Override
    public Role findByName(String roleName) {
        try {
            return entityManager.createNamedQuery("Role.findByName", Role.class)
                    .setParameter("name", roleName).getSingleResult();
        } catch (NoResultException e) {
            LOG.info("Entity not found");
            return null;
        }



    }

    @Override
    public Role save(Role role) {
        entityManager.persist(role);
        return role;
    }
}
