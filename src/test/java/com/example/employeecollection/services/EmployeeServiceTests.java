package com.example.employeecollection.services;

import com.example.employeecollection.exeptions.EmployeeAlreadyAddedException;
import com.example.employeecollection.exeptions.EmployeeNotFoundException;
import com.example.employeecollection.exeptions.InvalidInputException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class EmployeeServiceTests {
    EmployeeService out = new EmployeeService();

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of("Тест", "Тестовый", 15000, 2),
                Arguments.of("Баг", "Багович", 5000, 4));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    public void shouldTrowExceptWhenAddAlreadyContains(String firstName, String lastName, int salary, int depart) {
        out.addEmployee(firstName, lastName, salary, depart);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> {
                    out.addEmployee(firstName,lastName,salary,depart);
                } );
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    public void shouldThrowExceptWhenAddWhisIllegalName(String firstName, String lastName, int salary, int depart) {
        assertThrows(InvalidInputException.class,
                () -> {
                    out.addEmployee("@Тест", "!Тестовый", 15000, 2);
                });
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    public void shouldThrowWhenNotFound() {
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.addEmployee("Карл", "Маркс", 100, 1);
                });
    }
}
