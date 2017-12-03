package com.sens.try002.controller;

import com.sens.try002.dao.AddressDao;
import com.sens.try002.exception.EmailExistsException;
import com.sens.try002.model.Address;
import com.sens.try002.model.User;
import com.sens.try002.model.UserDto;
import com.sens.try002.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Sensible on 27.11.2017.
 */

@Controller
public class HomeController {

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user-page", method = RequestMethod.GET)
    public String user(Model model) {
        List<Address> addressList = addressDao.findAll();
        model.addAttribute("addresses", addressList);
        return "user-page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                            BindingResult result, WebRequest request, Errors errors) {
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(userDto);
        }
        if (registered == null) {
            result.rejectValue("login", "Registration error");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", userDto);
        } else {
            return new ModelAndView("login", "user", userDto);
        }
    }

    private User createUserAccount(UserDto userDto) {
        User registered = null;
        try {
            registered = userService.registrationNewUserAccount(userDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
}
