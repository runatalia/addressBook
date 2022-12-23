package com.addressBook.controller;


import com.addressBook.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestControllerAddressBook {

    @Autowired
    private Service Service;
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


