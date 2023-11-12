package com.example.employeecollection.services;

import com.example.employeecollection.exeptions.EmployeeAlreadyAddedException;
import com.example.employeecollection.exeptions.EmployeeNotFoundException;
import com.example.employeecollection.exeptions.EmployeeStorageIsFullException;
import com.example.employeecollection.exeptions.InvalidInputException;
import com.example.employeecollection.interfaces.IEmployeeService;
import com.example.employeecollection.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    public List<Employee> employeesList = new ArrayList<>(List.of(
            new Employee("Олег", "Олегович", 85000, 1),
            new Employee("Николай", "Николаевич", 68000, 3),
            new Employee("Даниил","Батькович",69000,2),
            new Employee("Кузьма","Ларионович",50000,3),
            new Employee("Некто","Нектович",90000,1),
            new Employee("Надежда","Ждановна",18500,1),
            new Employee("Софья","Кузьминична",46500,3)
    ));
    public final int MAXNUMEMPLOYEE = 10;

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public String welcome() {
        return "<h2>Добро пожаловать в список сотрудников<h2>" +
                "<h2>Доступные команды:</h2>" +
                "<b>/add?firstName=***&lastName=***&salary=***&department=***</b> - для добавления сотрудника" +
                "<br><b>/remove?firstName=***&lastName=***&department=***</b> - для удаления сотрудника" +
                "<br><b>/find?firstName=***&lastName=***&department=***</b> - для поиска сотрудника" +
                "<br>Где *** - передаваемые параметры";
    }

    public String addEmployee(String firstName, String lastName, int salary, int id) {
        Employee temp = new Employee(firstName, lastName, salary, id);
        if (employeesList.size() > 10) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (employeesList.get(i).equals(temp)) {
                    throw new EmployeeAlreadyAddedException("Такой сотрудник уже присутствует");
                }
            }
            temp.setFirstName(StringUtils.capitalize(firstName));
            temp.setLastName(StringUtils.capitalize(lastName));
            employeesList.add(temp);
            return "Сотрудник добавлен";
        } else {
            throw new InvalidInputException();
        }

    }

    public String removeEmployee(String firstName, String lastName, int id) {
        Employee temp = new Employee(firstName, lastName, id);
        if (employeesList.contains(temp)) {
            employeesList.remove(temp);
        }
        return "Сотрудник удален";
    }

    public String findEmployee(String firstName, String lastName, int id) {
        Employee temp = new Employee(firstName, lastName, id);
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
