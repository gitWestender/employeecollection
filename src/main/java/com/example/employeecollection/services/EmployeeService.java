package com.example.employeecollection.services;

import com.example.employeecollection.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    List<Employee> employeesList = new ArrayList<>();
    public final int MAXNUMEMPLOYEE = 10;

    public String welcome() {
        return "<h2>Добро пожаловать в список сотрудников<h2>"+
                "<h2>Доступные команды:</h2>"+
                "/add?firstName=***&lastName=***"+
                "<br>/remove?firstName=***&lastName=***"+
                "<br>/find?firstName=***&lastName=***"+
                "<br>Где *** - передаваемые параметры";
    }

    public String addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastName") String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (employeesList.size() <= 10) {
            employeesList.add(temp);
        }
        return "Сотрудник добавлен";
    }

    public String removeEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastName") String lastName) {
        Employee temp = new Employee(firstName, lastName);
        int index = employeesList.indexOf(temp);
        employeesList.remove(index);
        return "Сотрудник удален";
    }

    public String findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastName") String lastName) {
        Employee temp = new Employee(firstName, lastName);
        int index = employeesList.indexOf(temp);
        return employeesList.get(index).toString();
    }
}
