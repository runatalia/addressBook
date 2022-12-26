package com.addressBook.controller;



import com.addressBook.entity.Person;
import com.addressBook.service.ServiceAddressBook;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class RestControllerAddressBook {

    @Autowired
    private ServiceAddressBook service;
    
    
    @GetMapping("/persons")
    public String showAllPerson(Model model){
     List<Person> allPersons = service.showAllPerson();
   //  model.addAttribute("persons",allPersons);
    return "showAllPersonsView";
    }
//
//    @GetMapping("/persons")
//    public List<Employee> showAllEmployees() {
//        List<Employee> allEmployees = employeeService.getAllEmployees();
//        return allEmployees;
//    }
//
//    @GetMapping("/employees/{id}")
//    public Employee getEmployee(@PathVariable int id) {
//        Employee employee = employeeService.getEmployee(id);
//        if (employee == null) {
//            System.out.println("There is no employee with " + id + " in database.");
//        }
//        return employee;
//    }
//
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


