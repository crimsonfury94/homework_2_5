package com.example.homework25.homework_2_5.service;

import com.example.homework25.homework_2_5.data.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(int id, String firstName, String lastName);

    Employee deleteEmployee(int id, String firstName, String lastName);

    Employee getEmployee(int id, String firstName, String lastName);

    Collection<Employee> findAll();

}
