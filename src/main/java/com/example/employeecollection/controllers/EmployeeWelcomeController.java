package com.example.employeecollection.controllers;

import com.example.employeecollection.interfaces.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeWelcomeController {
    public final IEmployeeService empService;

    EmployeeWelcomeController(IEmployeeService iService) {
        this.empService = iService;
    }
    @GetMapping("/employee")
    public String welcome() {
        return empService.welcome();
    }

}
