package com.example.employeecollection.interfaces;

import com.example.employeecollection.model.Employee;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {
    Employee findEmpWithMaxSalaryOnDepart(int id);
    Employee findEmpWithMinSalaryOnDepart(int id);
    List<Employee> returnAllEmployeesOnDepart(int id);
    Map<Integer, List<Employee>> returnAllEmployees();
}
