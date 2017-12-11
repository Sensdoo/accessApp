package com.sens.try002.dao;

import com.sens.try002.model.Entrance;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Engineers on 08.12.2017.
 */

@Repository("entranceRepository")
public class EntranceRepositoryImpl implements EntranceRepository {

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    @Override
    public Entrance save(Entrance entrance) {
        entityManager.persist(entrance);
        return entrance;
    }

    @Override
    public Entrance update(Entrance entrance) {
        return entityManager.merge(entrance);
    }

    @Override
    public Entrance findByNumber(int number) {
        return entityManager.createNamedQuery("Entrance.findByNumber", Entrance.class)
                .setParameter("number", number).getSingleResult();
    }

    @Override
    public Entrance findById(Long id) {
        return entityManager.createNamedQuery("Entrance.findById", Entrance.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Entrance> findAll() {
        return entityManager.createNamedQuery("Entrance.findAll").getResultList();
    }

    @Override
    public Entrance findByIdWithComments(Long id) {
        return entityManager.createNamedQuery("Entrance.findByIdWithComments", Entrance.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Long count() {
        return entityManager.createNamedQuery("Entrance.count", Long.class).getSingleResult();
    }
}
