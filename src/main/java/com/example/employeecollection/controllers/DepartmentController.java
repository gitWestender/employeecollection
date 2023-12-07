package com.example.employeecollection.controllers;

import com.example.employeecollection.interfaces.IDepartmentService;
import com.example.employeecollection.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    public final IDepartmentService depService;

    DepartmentController(IDepartmentService iService) {
        this.depService = iService;
    }

    @GetMapping("/max-salary")
    public Employee findEmpWithMaxSalaryOnDepart(@RequestParam("id") int id) {
        return depService.findEmpWithMaxSalaryOnDepart(id);
    }

    @GetMapping("/min-salary")
    public Employee findEmpWithMinSalaryOnDepart(@RequestParam("id") int id) {
        return depService.findEmpWithMinSalaryOnDepart(id);
    }

    @GetMapping(value = "/all",params = "id")
    public List<Employee> returnAllEmployeesOnDepart(@RequestParam("id") int id) {
        return depService.returnAllEmployeesOnDepart(id);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> returnAllEmployees() {
        return depService.returnAllEmployees();
    }
}
