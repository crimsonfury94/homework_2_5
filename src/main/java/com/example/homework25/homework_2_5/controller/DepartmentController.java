package com.example.homework25.homework_2_5.controller;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.impl.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployees() {
        return departmentService.allEmployee();
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(int department) {
        return departmentService.departmentMinSalary(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(int department) {
        return departmentService.departmentMaxSalary(department);
    }

    @GetMapping(path = "/workers")
    public List<Employee> departmentWorkers(int department) {
        return departmentService.departmentWorkers(department);
    }
}
