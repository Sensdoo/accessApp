package com.sens.try001.service.interfaces;

import com.sens.try001.model.User;

import java.util.List;

/**
 * Created by momo on 21.10.2017.
 */
public interface UserService {

    void save(User user);
    List<User> findAllUsers();
}
