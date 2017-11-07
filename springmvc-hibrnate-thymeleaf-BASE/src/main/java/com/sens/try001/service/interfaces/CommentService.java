package com.sens.try001.service.interfaces;

import com.sens.try001.model.Comment;

/**
 * Created by Sensible on 07.11.2017.
 */

public interface CommentService {
    void save(Comment comment);
    Long count();
}
