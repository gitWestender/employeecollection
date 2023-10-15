package com.example.employeecollection.interfaces;

import com.example.employeecollection.exeptions.EmployeeAlreadyAddedException;
import com.example.employeecollection.exeptions.EmployeeNotFoundException;
import com.example.employeecollection.exeptions.EmployeeStorageIsFullException;

public interface IEmployeeService {
    String welcome();
    String addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;
    String removeEmployee(String firstName, String lastName) ;
    String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
}
