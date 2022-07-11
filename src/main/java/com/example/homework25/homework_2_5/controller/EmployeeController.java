package com.example.homework25.homework_2_5.controller;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(String firstName,
                                String lastName,
                                int department,
                                int workersSalary) {

        return employeeService.addEmployee(firstName, lastName, department, workersSalary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(String firstName,
                                   String lastName) {

        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(String firstName,
                                 String lastName) {

        return employeeService.getEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> allEmployee() {

        return employeeService.findAll();
    }
}
