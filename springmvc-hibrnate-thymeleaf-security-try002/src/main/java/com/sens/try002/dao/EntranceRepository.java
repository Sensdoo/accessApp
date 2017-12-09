package com.sens.try002.dao;

import com.sens.try002.model.Entrance;

import java.util.List;

/**
 * Created by Engineers on 08.12.2017.
 */
public interface EntranceRepository {
    Entrance save(Entrance entrance);
    Entrance update(Entrance entrance);
    Entrance findByNumber(int number);
    Entrance findById(Long id);
    List<Entrance> findAll();
    Entrance findByIdWithComments(Long id);
}
