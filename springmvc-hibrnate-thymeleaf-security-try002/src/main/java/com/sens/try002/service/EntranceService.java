package com.sens.try002.service;

import com.sens.try002.model.Entrance;

import java.util.List;

/**
 * Created by Engineers on 08.12.2017.
 */
public interface EntranceService {
    Entrance save(Entrance entrance);
    Entrance update(Entrance entrance);
    Entrance findByNumber(int number);
    Entrance findById(Long id);
    Entrance findByIdWithComments(Long id);
    List<Entrance> findAll();
}
