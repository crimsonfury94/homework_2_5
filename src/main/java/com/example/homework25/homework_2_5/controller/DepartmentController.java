package com.example.homework25.homework_2_5.controller;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.impl.DepartmentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/departments/all")
    public String allEmployee() {

        return departmentService.allEmployee();
    }
}
