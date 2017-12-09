package com.sens.try002.service;

import com.sens.try002.dao.EntranceRepository;
import com.sens.try002.model.Entrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Engineers on 08.12.2017.
 */

@Service("serviceRepository")
@Transactional
public class EntranceServiceImpl implements EntranceService {

    @Autowired
    private EntranceRepository entranceRepository;

    @Override
    public Entrance save(Entrance entrance) {
        return entranceRepository.save(entrance);
    }

    @Override
    public Entrance update(Entrance entrance) {
        return entranceRepository.update(entrance);
    }

    @Override
    @Transactional(readOnly = true)
    public Entrance findByNumber(int number) {
        return entranceRepository.findByNumber(number);
    }

    @Override
    @Transactional(readOnly = true)
    public Entrance findById(Long id) {
        return entranceRepository.findById(id);
    }

    @Override
    public Entrance findByIdWithComments(Long id) {
        return entranceRepository.findByIdWithComments(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entrance> findAll() {
        return entranceRepository.findAll();
    }
}
