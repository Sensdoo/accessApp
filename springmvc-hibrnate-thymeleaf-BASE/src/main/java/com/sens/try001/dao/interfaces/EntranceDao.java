package com.sens.try001.dao.interfaces;

import com.sens.try001.model.Entrance;

import java.util.List;

/**
 * Created by Sensible on 07.11.2017.
 */

public interface EntranceDao {
    void save(Entrance entrance);
    List<Entrance> findAll();
    Entrance findById(long id);
    Entrance findByIdWithComments(long id);
    Long count();
}
