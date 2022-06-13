package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    public String allEmployee() {
        final List<Employee> employeeList = (List<Employee>) employeeService.findAll();
        List<String> streamEmployee = employeeList.stream()
                .map(e -> e.getFirstName() + e.getLastName())
                        .toList();
        return streamEmployee.toString();
    }

}
