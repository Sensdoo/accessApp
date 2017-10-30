package com.sens.try001.controller;

import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import com.sens.try001.model.User;
import com.sens.try001.service.interfaces.AddressServise;
import com.sens.try001.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by momo on 21.10.2017.
 */

@Controller
//@SessionAttributes( {"address"} )
public class HomeController {

    @Autowired
    private AddressServise addressServise;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("address", new Address());
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String home(@ModelAttribute("address") Address address) {
        if (address != null)addressServise.save(address);
        return "home";
    }

    @RequestMapping(name = "/list", method = RequestMethod.GET)
    public String getList(Model model) {
        List<Address> list = addressServise.findAll();
        model.addAttribute("addresses", list);
        return "list";
    }

    @RequestMapping(value = { "/edit/{id}/address" }, method = RequestMethod.GET)
    public String editAddress(@PathVariable long id, Model model) {
        Address address = addressServise.findById(id);
        model.addAttribute("address", address);
//        model.addAttribute("edit", true);
        return "edit";
    }

    @RequestMapping(value = { "/edit/{id}/address" }, method = RequestMethod.POST)
    public String updateAddress(@PathVariable long id, @ModelAttribute("address") Address address, Model model) {
        addressServise.updateAddress(address);
        return "edit";
    }

    @RequestMapping(value = { "/access/{id}/address" }, method = RequestMethod.GET)
    public String openAddress(@PathVariable long id, ModelMap model) {
        Address address = addressServise.findById(id);
        Entrance entrance = new Entrance();
        Set<Entrance> entranceList;
        entranceList = address.getEntranceSet();
        model.put("entranceList", entranceList);
        model.addAttribute("address", address);
        model.addAttribute("entrance", entrance);
        return "access";
    }

    @RequestMapping(value = { "/access/{id}/address" }, method = RequestMethod.POST)
    public String openAddress(@PathVariable long id,
                              @ModelAttribute("entrance")Entrance entrance, ModelMap model) {

//        Address address = addressServise.findById(id);
        if (entrance != null) {
//            address.addEntrance(entrance);
            addressServise.updateAddress(id, entrance);
        }
        return "redirect:access";
    }
}
