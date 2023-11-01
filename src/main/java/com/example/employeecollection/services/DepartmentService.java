package com.example.employeecollection.services;

import com.example.employeecollection.exeptions.EmployeeNotFoundException;
import com.example.employeecollection.interfaces.IDepartmentService;
import com.example.employeecollection.interfaces.IEmployeeService;
import com.example.employeecollection.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService {
    public final IEmployeeService empService;

    DepartmentService(EmployeeService service) {
        this.empService = service;
    }



    public Employee findEmpWithMaxSalaryOnDepart(int id) {

        return empService.getEmployeesList().stream()
                .filter(e -> e.getDepartment() == id)
                .max(Comparator.comparingInt(emp -> emp.getSalary()))
                .orElseThrow();
    }

    public Employee findEmpWithMinSalaryOnDepart(int id) {
        return empService.getEmployeesList().stream()
                .filter(e -> e.getDepartment() == id)
                .min(Comparator.comparingInt(emp -> emp.getSalary()))
                .orElseThrow();
    }

    public List<Employee> returnAllEmployeesOnDepart(int id) {
        List<Employee> tempList = empService.getEmployeesList().stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
        return tempList;
    }

    public  Map<Integer, List<Employee>> returnAllEmployees() {
        return empService.getEmployeesList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
