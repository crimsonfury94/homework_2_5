package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.exceptions.EmployeeAlreadyAddedException;
import com.example.homework25.homework_2_5.exceptions.EmployeeNotFoundException;
import com.example.homework25.homework_2_5.exceptions.EmployeeStorageIsFullException;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    List<Employee> employees = List.of(
            new Employee("Валентина", "Бусина"),
            new Employee("Степан", "Семёнов"),
            new Employee("Петр", "Дарницкий"),
            new Employee("Станислав", "Евстегнеев"),
            new Employee("Егор", "Шляпин"),
            new Employee("Валерий", "Сырков"),
            new Employee("Елена", "Шарикова"),
            new Employee("Юлия", "Кысь"),
            new Employee("Валерия", "Кошкина")

    );


    @Override
    public void addEmployee(Employee employee) {

        for (int lastIndex = 0; lastIndex < employees.size(); lastIndex++) {

            if (lastIndex >= employees.size()) {
                throw new EmployeeStorageIsFullException();
            }
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        employees.add(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            String employeeName = employee.getFirstName() + employee.getLastName();
            if (employees.equals(employeeName)) {
                throw new EmployeeNotFoundException();
            }
        }
        employees.remove(employee);
    }

    @Override
    public String getEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            String employeeName = employee.getFirstName() + employee.getLastName();
            if (employeeName.equals(employees)) {
                throw new EmployeeNotFoundException();
            }
        }
        return employees.toString();
    }
}
