package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {

        this.employeeService = employeeService;
    }


    public Map<Integer, List<Employee>> allEmployee() {

        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toList()));
    }


    public Employee departmentMinSalary(int department) {

        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getWorkersSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee departmentMaxSalary(int department) {

        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getWorkersSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public List<Employee> departmentWorkers(int department) {

        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }
}
