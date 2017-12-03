package com.sens.try001.controller;

import com.sens.try001.model.Address;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

/**
 * Created by momo on 06.11.2017.
 */
public class AAA {

    @Autowired
    private AddressService addressService;

    @RequestMapping(name = "/list", method = RequestMethod.GET)
    public String getList(Model model) {
        List<Address> list = addressService.findAll();
        model.addAttribute("addresses", list);
        return "list";
    }

//    @RequestMapping(value = { "/edit/{id}/address" }, method = RequestMethod.GET)
//    public String editAddress(@PathVariable long id, Model model) {
//        Address address = addressService.findById(id);
//        model.addAttribute("address", address);
////        model.addAttribute("edit", true);
//        return "edit";
//    }

//    @RequestMapping(value = { "/edit/{id}/address" }, method = RequestMethod.POST)
//    public String updateAddress(@PathVariable long id, @ModelAttribute("address") Address address, Model model) {
//        addressService.updateAddress(address);
//        return "edit";
//    }
//
//    @RequestMapping(value = { "/access/{id}/address" }, method = RequestMethod.GET)
//    public String openAddress(@PathVariable long id, ModelMap model) {
//        Address address = addressService.findById(id);
//        Entrance entrance = new Entrance();
//        if (address.getEntranceSet().size() > 0) {
//            Set<Entrance> entranceList = address.getEntranceSet();
//            model.put("entranceList", entranceList);
//        }
//        model.addAttribute("address", address);
//        model.addAttribute("entrance", entrance);
//        return "access";
//    }
//
//    @RequestMapping(value = { "/access/{id}/address" }, method = RequestMethod.POST)
//    public String openAddress(@PathVariable long id,
//                              @ModelAttribute("entrance")Entrance entrance, ModelMap model) {
//
////        Address address = addressService.findById(id);
//        if (entrance != null) {
////            address.addEntrance(entrance);
//            addressService.updateAddress(id, entrance);
//        }
//        return "redirect:access";
//    }
}
