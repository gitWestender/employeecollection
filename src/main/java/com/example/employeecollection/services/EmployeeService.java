package com.example.employeecollection.services;

import com.example.employeecollection.exeptions.EmployeeAlreadyAddedException;
import com.example.employeecollection.exeptions.EmployeeNotFoundException;
import com.example.employeecollection.exeptions.EmployeeStorageIsFullException;
import com.example.employeecollection.interfaces.IEmployeeService;
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
        return "<h2>Добро пожаловать в список сотрудников<h2>" +
                "<h2>Доступные команды:</h2>" +
                "/add?firstName=***&lastName=***" +
                "<br>/remove?firstName=***&lastName=***" +
                "<br>/find?firstName=***&lastName=***" +
                "<br>Где *** - передаваемые параметры";
    }

    public String addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (employeesList.size() > 10) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).equals(temp)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже присутствует");
            }
        }
        employeesList.add(temp);
        return "Сотрудник добавлен";
    }

    public String removeEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (employeesList.contains(temp)) {
            employeesList.remove(temp);
        }
        return "Сотрудник удален";
    }

    public String findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        Employee temp = new Employee(firstName, lastName);
        int index = 0;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).equals(temp)) {
                index = i;
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
        return employeesList.get(index).toString();
    }
}
