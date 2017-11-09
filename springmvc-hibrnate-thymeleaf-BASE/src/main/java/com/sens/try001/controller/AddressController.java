package com.sens.try001.controller;

import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.AddressService;
import com.sens.try001.service.interfaces.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

/**
 * Created by momo on 06.11.2017.
 */

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private EntranceService entranceService;

    @RequestMapping(value = "/findAddress/{id}/access", method = RequestMethod.GET)
    public String openAccess(@PathVariable long id, Model model) {
        Address address = addressService.findByIdWithEntrances(id);
        Entrance entrance = new Entrance();

        if (address.getEntrances().size() > 0) {
            List<Entrance> entrances = address.getEntrances();
            model.addAttribute("entrances", entrances);
        } else {
            model.addAttribute("entrances", null);
        }

        model.addAttribute("entrance", entrance);
        model.addAttribute("address", address);

        return "access";
    }

    @RequestMapping(value = "/findAddress/{id}/access", method = RequestMethod.POST)
    public String addAccess(@PathVariable long id, @ModelAttribute("entrance") Entrance entrance, Model model) {
        Address address = addressService.findByIdWithEntrances(id);

        if ((entrance.getAccess() != null & entrance.getAccess() != "") & entrance.getNumber() > 0) {
            Long entranceId = entranceService.count();
            entrance.setId(++entranceId);
            address.addEntrance(entrance);
            addressService.save(address);
        }

        if (address.getEntrances().size() > 0) {
            List<Entrance> entrances = address.getEntrances();
            model.addAttribute("entrances", entrances);
        } else {
            model.addAttribute("entrances", null);
        }

        model.addAttribute("address", address);

        return "access";
    }

}
