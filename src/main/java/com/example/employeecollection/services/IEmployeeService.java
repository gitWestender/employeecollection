package com.example.employeecollection.services;

public interface IEmployeeService {
    String welcome();
    String addEmployee(String firstName, String lastName);
    String removeEmployee(String firstName, String lastName);
    String findEmployee(String firstName, String lastName);
}
