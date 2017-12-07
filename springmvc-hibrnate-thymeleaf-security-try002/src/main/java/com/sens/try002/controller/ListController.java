package com.sens.try002.controller;

import com.sens.try002.model.Address;
import com.sens.try002.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Sensible on 05.12.2017.
 */

@Controller
public class ListController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String lists(@PathVariable("name") String streetName, Model model) {
        List<Address> addresses = addressService.findAllByStreetName(streetName);
        model.addAttribute("addresses", addresses);
        model.addAttribute("street", streetName);
        return "list";
    }

//    @RequestMapping(name = "/lists/zhernovskaya3", method = RequestMethod.GET)
//    public String zhernovskaya3(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("3-я Жерновская");
//        model.addAttribute("addresses", addresses);
//        return "lists/zhernovskaya3";
//    }
//
//    @RequestMapping(name = "/lists/zhernovskaya6", method = RequestMethod.GET)
//    public String zhernovskaya6(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("6-я Жерновская");
//        model.addAttribute("addresses", addresses);
//        return "lists/zhernovskaya6";
//    }
//
//    @RequestMapping(name = "/lists/industrialniy", method = RequestMethod.GET)
//    public String industrialniy(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Индустриальный");
//        model.addAttribute("addresses", addresses);
//        return "lists/industrialniy";
//    }
//
//    @RequestMapping(name = "/lists/irinovskiy", method = RequestMethod.GET)
//    public String irinovskiy(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Ириновский");
//        model.addAttribute("addresses", addresses);
//        return "lists/irinovskiy";
//    }
//
//    @RequestMapping(name = "/lists/kommuni", method = RequestMethod.GET)
//    public String kommuni(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Коммуны");
//        model.addAttribute("addresses", addresses);
//        return "lists/kommuni";
//    }
//
//    @RequestMapping(name = "/lists/kosigina", method = RequestMethod.GET)
//    public String kosigina(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Косыгина");
//        model.addAttribute("addresses", addresses);
//        return "lists/kosigina";
//    }
//
//    @RequestMapping(name = "/lists/lazo", method = RequestMethod.GET)
//    public String lazo(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Лазо");
//        model.addAttribute("addresses", addresses);
//        return "lists/lazo";
//    }
//
//    @RequestMapping(name = "/lists/nastavnikov", method = RequestMethod.GET)
//    public String nastavnikov(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Наставников");
//        model.addAttribute("addresses", addresses);
//        return "lists/nastavnikov";
//    }
//
//    @RequestMapping(name = "/lists/osipenko", method = RequestMethod.GET)
//    public String osipenko(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Осипенко");
//        model.addAttribute("addresses", addresses);
//        return "lists/osipenko";
//    }
//
//    @RequestMapping(name = "/lists/otechestvennaya", method = RequestMethod.GET)
//    public String otechestvennaya(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Отечественная");
//        model.addAttribute("addresses", addresses);
//        return "lists/otechestvennaya";
//    }
//
//    @RequestMapping(name = "/lists/peredovikov", method = RequestMethod.GET)
//    public String peredovikov(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Передовиков");
//        model.addAttribute("addresses", addresses);
//        return "lists/peredovikov";
//    }
//
//    @RequestMapping(name = "/lists/udarnikov", method = RequestMethod.GET)
//    public String udarnikov(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Ударников");
//        model.addAttribute("addresses", addresses);
//        return "lists/udarnikov";
//    }
//
//    @RequestMapping(name = "/lists/entuziastov", method = RequestMethod.GET)
//    public String entuziastov(Model model) {
//        List<Address> addresses = addressService.findAllByStreetName("Энтузиастов");
//        model.addAttribute("addresses", addresses);
//        return "lists/entuziastov";
//    }
}
