package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.exceptions.EmployeeAlreadyAddedException;
import com.example.homework25.homework_2_5.exceptions.EmployeeNotFoundException;
import com.example.homework25.homework_2_5.exceptions.EmployeeStorageIsFullException;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee) {
        return employee.getFirstName() + employee.getLastName();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int workersSalary) {

        Employee employee = new Employee(firstName, lastName, department, workersSalary);

        if (employees.containsKey(getKey(employee))) {

            throw new EmployeeAlreadyAddedException();
        }

        if (employees.size() < LIMIT) {
            return employees.put(getKey(employee), employee);

        }
        throw new EmployeeStorageIsFullException();
    }


    @Override
    public Employee deleteEmployee(String firstName, String lastName, int department, int workersSalary) {
        Employee employee = new Employee(firstName, lastName, department, workersSalary);
        if (!employees.containsKey(getKey(employee))) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(getKey(employee));
    }


    @Override
    public Employee getEmployee(String firstName, String lastName, int department, int workersSalary) {
        Employee employee = new Employee(firstName, lastName, department, workersSalary);
        if (!employees.containsKey(getKey(employee))) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
}
