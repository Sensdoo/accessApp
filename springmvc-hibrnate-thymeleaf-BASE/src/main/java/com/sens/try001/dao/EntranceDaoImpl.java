package com.sens.try001.dao;

import com.sens.try001.dao.interfaces.EntranceDao;
import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Sensible on 07.11.2017.
 */

@Repository("entranceDao")
public class EntranceDaoImpl implements EntranceDao {

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;


    @Override
    public void save(Entrance entrance) {
        entityManager.merge(entrance);
    }

    @Override
    public List<Entrance> findAll() {
        return entityManager.createNamedQuery("Entrance.findAll", Entrance.class).getResultList();
    }

    @Override
    public Entrance findById(long id) {
        TypedQuery<Entrance> query = entityManager.createNamedQuery("Entrance.findById", Entrance.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Entrance findByIdWithComments(long id) {
        TypedQuery<Entrance> query = entityManager.createNamedQuery("Entrance.findByIdWithComments", Entrance.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Long count() {
        return entityManager.createNamedQuery("Entrance.count", Long.class).getSingleResult();
    }
}
