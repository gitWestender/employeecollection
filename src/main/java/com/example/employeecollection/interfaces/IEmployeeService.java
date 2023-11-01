package com.example.employeecollection.interfaces;

import com.example.employeecollection.exeptions.EmployeeAlreadyAddedException;
import com.example.employeecollection.exeptions.EmployeeNotFoundException;
import com.example.employeecollection.exeptions.EmployeeStorageIsFullException;
import com.example.employeecollection.model.Employee;

import java.util.List;

public interface IEmployeeService {
    String welcome();
    String addEmployee(String firstName, String lastName, int salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;
    String removeEmployee(String firstName, String lastName, int department) ;
    String findEmployee(String firstName, String lastName, int department) throws EmployeeNotFoundException;

    List<Employee> getEmployeesList();
}
