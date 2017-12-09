package com.sens.try002.controller;

import com.sens.try002.model.Address;
import com.sens.try002.model.Entrance;
import com.sens.try002.service.AddressService;
import com.sens.try002.service.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sensible on 05.12.2017.
 */

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private EntranceService entranceService;

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public ModelAndView listAddresses(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        Address address = addressService.findByIdWithEntrances(id);
        Entrance entrance = new Entrance();

        if (address.getEntrances().size() > 0) {
            List<Entrance> entrances = address.getEntrances();
            mav.addObject("entrances", entrances);
        } else {
            mav.addObject("entrances", null);
        }

        mav.addObject("address", address);
        mav.addObject("entrance", entrance);
        mav.setViewName("access");
        return mav;
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.POST)
    public ModelAndView addEntrance(@PathVariable("id") Long id, @ModelAttribute("entrance") Entrance entrance) {
        ModelAndView mav = new ModelAndView();
        Address address = addressService.findByIdWithEntrances(id);

        if ((entrance.getAccess() != null & entrance.getAccess() != "") & entrance.getNumber() > 0) {
            if (address.getEntrances() != null && address.getEntrances().size() > 0) {
                for (Entrance e : address.getEntrances()) {
                    if (e.getNumber() == entrance.getNumber()) {
                        e.setAccess(entrance.getAccess());
                        e.setKey(entrance.getKey());
                        addressService.save(address);
                    } else {
                        Entrance existEntrance = entranceService.save(entrance);
                        address.addEntrance(existEntrance);
                        addressService.save(address);
                    }
                }
            } else {
                address.addEntrance(entrance);
                entranceService.save(entrance);
                addressService.save(address);
            }
            List<Entrance> entrances = address.getEntrances();
            mav.addObject("entrances", entrances);
        } else {
            mav.addObject("entrances", null);
        }

        mav.addObject("address", address);

        mav.setViewName("access");
        return mav;
    }
}
