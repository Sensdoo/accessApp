package com.sens.try002.service;

import com.sens.try002.exception.EmailExistsException;
import com.sens.try002.model.User;
import com.sens.try002.model.UserDto;

/**
 * Created by Sensible on 29.11.2017.
 */
public interface UserService {
    User registrationNewUserAccount(UserDto userDto) throws EmailExistsException;
























}
