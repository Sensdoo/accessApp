package com.sens.try002.controller;

import com.sens.try002.model.Address;
import com.sens.try002.model.Entrance;
import com.sens.try002.service.AddressService;
import com.sens.try002.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public ModelAndView listAddresses(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        Address address = addressService.findById(id);
        Entrance entrance = new Entrance();
        mav.addObject("address", address);
        mav.addObject("entrance", entrance);
        mav.setViewName("access");
        return mav;
    }
}
