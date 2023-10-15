package com.example.employeecollection.exeptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String msg) {
        super(msg);
    }
}
