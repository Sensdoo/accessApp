package com.sens.try002.dao;

import com.sens.try002.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * Created by Sensible on 29.11.2017.
 */

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    private Log LOG = LogFactory.getLog(UserRepository.class);

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    @Override
    public User findByLogin(String login) {
        try {
            return entityManager.createNamedQuery("User.findByLogin", User.class)
                    .setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            LOG.info("Entity not found");
            return null;
        }
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

}
