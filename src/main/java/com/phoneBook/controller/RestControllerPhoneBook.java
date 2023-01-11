package com.phoneBook.controller;


import com.phoneBook.entity.Organization;
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
@RequestMapping("/api/")
public class RestControllerPhoneBook {
    
    @Autowired
    private ServicePhoneBook service;

    @GetMapping("persons")
    public String showAllPersonForAll(Model model) {
        List<Person> allPersons = service.showAllPerson();
        model.addAttribute("persons", allPersons);
        return "showAllPersonsView";
    }

    @GetMapping("persons/{id}")
    public String getPerson(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Person person = service.getPerson(id);
        redirectAttributes.addFlashAttribute("person", person);
        return "redirect:/api/persons";
    }
    
     @GetMapping("organizations/{id}")
    public String getOrganization(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Organization organization = service.getOrganization(id);
        redirectAttributes.addFlashAttribute("organization", organization);
        System.out.println(id);
        return "redirect:/api/persons";
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
