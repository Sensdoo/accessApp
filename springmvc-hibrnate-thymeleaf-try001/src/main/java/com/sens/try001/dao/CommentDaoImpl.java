package com.sens.try001.dao;

import com.sens.try001.dao.interfaces.CommentDao;
import com.sens.try001.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Sensible on 07.11.2017.
 */

@Repository("commentDao")
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public Long count() {
        return entityManager.createNamedQuery("Comment.count", Long.class).getSingleResult();
    }
}
