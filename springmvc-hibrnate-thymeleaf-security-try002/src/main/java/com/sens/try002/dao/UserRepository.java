package com.sens.try002.dao;

import com.sens.try002.model.User;

/**
 * Created by Sensible on 29.11.2017.
 */
public interface UserRepository {
    User findByLogin(String login);
    User save(User user);
}
