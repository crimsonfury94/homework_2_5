package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.exceptions.EmployeeAlreadyAddedException;
import com.example.homework25.homework_2_5.exceptions.EmployeeNotFoundException;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Integer, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(int id, String firstName, String lastName) {

        Employee employee = new Employee(id, firstName, lastName);
        if (employees.containsKey(employee.getId())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getId(), employee);
        return employee;
    }


    @Override
    public Employee deleteEmployee(int id, String firstName, String lastName) {
        Employee employee = new Employee(id, firstName, lastName);
        if (employees.containsKey(employee.getId())) {
            return employees.remove(employee.getId());
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Employee getEmployee(int id, String firstName, String lastName) {
        Employee employee = new Employee(id, firstName, lastName);
        if (employees.containsKey(employee.getId())) {
            return employees.get(employee.getId());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
