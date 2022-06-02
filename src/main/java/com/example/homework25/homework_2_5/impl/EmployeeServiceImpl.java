package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.exceptions.EmployeeStorageIsFullException;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


  List<Employee> employees = List.of(
new Employee("Валентина","Бусина"),
new Employee("Степан","Семёнов"),
new Employee("Петр","Дарницкий"),
new Employee("Станислав","Евстегнеев"),
new Employee("Егор","Шляпин"),
new Employee("Валерий","Сырков"),
new Employee("Елена","Шарикова"),
new Employee("Юлия","Кысь"),
new Employee("Валерия","Кошкина")

    );


    @Override
    public void addEmployee(Employee employee) {
      if(employee.equals(employees.size()))
        throw new EmployeeStorageIsFullException();
      employees.add(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
      employees.remove(employee);
    }

    @Override
    public void getEmployee(Employee employee) {

    }
}
