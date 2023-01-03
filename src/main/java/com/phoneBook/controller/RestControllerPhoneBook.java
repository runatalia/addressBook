package com.phoneBook.controller;

import com.phoneBook.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import com.phoneBook.service.ServicePhoneBook;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class RestControllerPhoneBook {

    @Autowired
    private ServicePhoneBook service;

    @GetMapping("/persons")
    public String showAllPerson(Model model) {
        List<Person> allPersons = service.showAllPerson();
        int arr[] = new int[allPersons.size()];
        for(int i=1;i<arr.length;i++){
        arr[i]=i;}
        model.addAttribute("persons", allPersons);
        model.addAttribute("arr",arr);
        
        return "showAllPersonsView";
    }

    @GetMapping("/personalDetails/{id}")
    public String getPerson(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Person person = service.getPerson(id);
        model.addAttribute("person", person);
        redirectAttributes.addFlashAttribute("person", person);
        return "redirect:/persons";
    }

//    @PostMapping("/employees")
//    public Employee addNewEmployee(@RequestBody Employee employee) {
//        employeeService.saveEmployee(employee);
//        return employee;
//    }
//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        employeeService.saveEmployee(employee);
//        return employee;
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public String deleteEmployee(@PathVariable int id) {
//        Employee employee = employeeService.getEmployee(id);
//        if (employee == null) {
//             System.out.println("There is no employee with id " + id);
//        }
//        employeeService.deleteEmployee(id);
//        return "Employee with ID = " + id + " deleted.";
}
