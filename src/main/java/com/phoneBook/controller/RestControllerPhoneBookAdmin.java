package com.phoneBook.controller;

import com.phoneBook.entity.City;
import com.phoneBook.entity.Person;
import com.phoneBook.service.ServicePhoneBook;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/api/")
public class RestControllerPhoneBookAdmin {

    @Autowired
    private ServicePhoneBook service;

    @GetMapping("personsForAdmin")
    public String showAllPersonForAdmin(Model model) {
        List<City> allCity = service.showAllCity();
        List<Person> allPersons = service.showAllPerson();
        Map<String, List<City>> mapCities = allCity.stream().collect(Collectors.groupingBy(e -> e.getRegion()));
        model.addAttribute("cities", mapCities);
        model.addAttribute("persons", allPersons);
        return "showAllPersonsViewForAdmin";
    }
}
