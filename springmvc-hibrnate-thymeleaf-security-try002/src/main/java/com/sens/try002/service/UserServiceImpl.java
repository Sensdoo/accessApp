package com.sens.try002.service;

import com.sens.try002.dao.RoleRepository;
import com.sens.try002.dao.UserRepository;
import com.sens.try002.exception.EmailExistsException;
import com.sens.try002.model.Role;
import com.sens.try002.model.User;
import com.sens.try002.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sensible on 29.11.2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User registrationNewUserAccount(UserDto userDto) throws EmailExistsException {
        if (loginExists(userDto.getLogin())) {
            throw  new EmailExistsException("There is an account with that email address: " + userDto.getLogin());
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setLogin(userDto.getLogin());
        user.setRoles(Arrays.asList(roleRepository.findByName("USER")));
        return userRepository.save(user);
    }

    private boolean loginExists(String login) {
        User user = userRepository.findByLogin(login);
        if (user != null) return true;
        return false;
    }
}
