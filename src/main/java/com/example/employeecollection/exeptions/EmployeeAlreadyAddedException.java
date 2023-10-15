package com.example.employeecollection.exeptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String msg) {
        super(msg);
    }
}
