package com.example.employeecollection.exeptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}
