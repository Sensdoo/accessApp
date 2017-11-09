package com.sens.try001.service;

import com.sens.try001.dao.interfaces.CommentDao;
import com.sens.try001.model.Comment;
import com.sens.try001.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sensible on 07.11.2017.
 */

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }


    //транзакция для запроса не будет создана
    @Transactional(propagation = Propagation.NEVER)
    @Override
    public Long count() {
        return commentDao.count();
    }
}
