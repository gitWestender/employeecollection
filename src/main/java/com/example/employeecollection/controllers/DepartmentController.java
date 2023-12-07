package com.example.employeecollection.controllers;

import com.example.employeecollection.interfaces.IDepartmentService;
import com.example.employeecollection.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    public final IDepartmentService depService;

    DepartmentController(IDepartmentService iService) {
        this.depService = iService;
    }

    @GetMapping("/{id}/max-salary")
    public Employee findEmpWithMaxSalaryOnDepart(@PathVariable("id") int id) {
        return depService.findEmpWithMaxSalaryOnDepart(id);
    }

    @GetMapping("/{id}/min-salary")
    public Employee findEmpWithMinSalaryOnDepart(@PathVariable("id") int id) {
        return depService.findEmpWithMinSalaryOnDepart(id);
    }

    @GetMapping("/{id}/all")
    public List<Employee> returnAllEmployeesOnDepart(@PathVariable("id") int id) {
        return depService.returnAllEmployeesOnDepart(id);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> returnAllEmployees() {
        return depService.returnAllEmployees();
    }

    @GetMapping("/{id}/salary/sum")
    public Double sumOfSalaryOnAllDeps(@PathVariable ("id") int id) {
        return depService.sumOfSalary(id);
    }
}
