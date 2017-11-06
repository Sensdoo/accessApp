package com.sens.try001.controller;

import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

/**
 * Created by momo on 06.11.2017.
 */

@Controller
public class AccessController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/access/{id}/address", method = RequestMethod.GET)
    public String access(@PathVariable long id, Model model) {
        Address address = addressService.findByIdWithEntrances(id);

        if (address.getEntrances().size() > 0) {
            Set<Entrance> entrances = address.getEntrances();
            model.addAttribute("entrances", entrances);
        } else {
            model.addAttribute("entrances", null);
        }

        model.addAttribute("address", address);

        return "access";
    }

    @RequestMapping(value = "/access2/{id}/address", method = RequestMethod.GET)
    public String access2(@PathVariable long id, Model model) {
        Address address = addressService.findById(id);

        model.addAttribute("address", address);

        return "access";
    }
}
