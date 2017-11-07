package com.sens.try001.service;

import com.sens.try001.dao.interfaces.EntranceDao;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sensible on 07.11.2017.
 */

@Service
@Transactional
public class EntranceServiceImpl implements EntranceService {

    @Autowired
    private EntranceDao entranceDao;

    @Override
    public void save(Entrance entrance) {
        entranceDao.save(entrance);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Entrance> findAll() {
        return entranceDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Entrance findById(long id) {
        return entranceDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Entrance findByIdWithComments(long id) {
        return entranceDao.findByIdWithComments(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Long count() {
        return entranceDao.count();
    }
}
