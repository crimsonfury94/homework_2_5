package com.example.homework25.homework_2_5.controller;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("name") String firstName,
                              @RequestParam("lastname") String lastName) {
        Employee employee = new Employee(firstName,lastName);
         employeeService.addEmployee(employee);
        return "Employee added";
    }
}
