package com.example.employeecollection.controllers;

import com.example.employeecollection.interfaces.IEmployeeService;
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
    public String addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
                              @RequestParam("salary") Integer salary, @RequestParam("department") int id) {
        return empService.addEmployee(firstName, lastName, salary, id);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
                                 @RequestParam("department") int id) {
        return empService.removeEmployee(firstName, lastName, id);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
                               @RequestParam("department") int id) {
        return empService.findEmployee(firstName, lastName, id);
    }
}
