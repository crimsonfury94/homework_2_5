package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Ivan", "Petrov", 2, 50000);
        employee2 = new Employee("Semen", "Ivanov", 3, 20000);
        employee3 = new Employee("Alexey", "Stepanov", 4, 570000);

        employeeService = new EmployeeServiceImpl();

        employeeService.addEmployee("Ivan", "Petrov", 2, 50000);
        employeeService.addEmployee("Semen", "Ivanov", 3, 20000);
        employeeService.addEmployee("Alexey", "Stepanov", 4, 570000);
    }

    @Test
    public void getAll() {

        List<Employee> expected = employeeService.findAll();

        List<Employee> actual = new ArrayList<>();

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllEmployeeNotNull() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<Employee> expected = employeeService.findAll();
        Assertions.assertNotNull(expected);

    }

    @Test
    void shouldReturnResultWhenAddSameEmployee() {

    }

    @Test
    void shouldReturnResultWhenAddIncorrectEmployeeName() {
    }

    @Test
    void shouldReturnResultWhenDeleteNullEmployee() {
    }

    @Test
    void shouldReturnResultWhenDeleteEmployeeNoLastName() {
    }

    @Test
    void shouldReturnResultWhenDeleteEmployeeNoFirstName() {
    }

    @Test
    void shouldReturnResultWhenGetNullEmployee() {
    }

    @Test
    void shouldReturnResultWhenGetEmployeeNoLastName() {
    }

    @Test
    void shouldReturnResultWhenGetEmployeeNoFirstName() {
    }
}