package com.example.employeecollection.controllers;

import com.example.employeecollection.services.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    public final IEmployeeService empService;

    EmployeeController(IEmployeeService iService) {
        this.empService = iService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return empService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return empService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return empService.findEmployee(firstName, lastName);
    }
}
