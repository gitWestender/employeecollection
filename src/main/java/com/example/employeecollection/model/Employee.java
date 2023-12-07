package com.example.employeecollection.model;

import java.util.Objects;

import static org.springframework.util.StringUtils.capitalize;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;

    public Employee() {

    }

    public Employee(String firstName, String lastName, int department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.department = department;
    }

    public Employee(String firstName, String lastName, Integer salary, int department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getDepartment() {
        return department;
    }
    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (salary != employee.salary) return false;
        if (department != employee.department) return false;
        if (!Objects.equals(firstName, employee.firstName)) return false;
        return Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + department;
        return result;
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + ", Фамилия: " + lastName;
    }
}
