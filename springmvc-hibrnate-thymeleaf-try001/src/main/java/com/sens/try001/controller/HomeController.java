package com.sens.try001.controller;

import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by momo on 21.10.2017.
 */

@Controller
public class HomeController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Address> addresses = addressService.findAll();
        model.addAttribute("addresses", addresses);
        return "home";
    }

}
