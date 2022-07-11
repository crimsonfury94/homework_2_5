package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.exceptions.EmployeeAlreadyAddedException;
import com.example.homework25.homework_2_5.exceptions.EmployeeNotFoundException;
import com.example.homework25.homework_2_5.exceptions.WrongNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class EmployeeServiceImplTest {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();


    @Test
    public void getAll() {


        Employee employee1 = new Employee("Ivan", "Petrov", 2, 50000);
        Employee employee2 = new Employee("Semen", "Ivanov", 3, 20000);
        Employee employee3 = new Employee("Alexey", "Stepanov", 4, 570000);


        employeeService.addEmployee("Ivan", "Petrov", 2, 50000);
        employeeService.addEmployee("Semen", "Ivanov", 3, 20000);
        employeeService.addEmployee("Alexey", "Stepanov", 4, 570000);


        List<Employee> expected = employeeService.findAll();
        List<Employee> actual = new ArrayList<>();

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);


        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void getAllEmployeeNotNull() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<Employee> expected = employeeService.findAll();
        assertThat(expected).isNotNull();

    }

    @ParameterizedTest
    @MethodSource("params")
    void shouldReturnResultWhenAddSameEmployee(String firstName,
                                               String lastName,
                                               int department,
                                               int workerSalary) {
        Employee expected = new Employee(firstName, lastName, department, workerSalary);
        assertThat(employeeService.addEmployee(firstName, lastName, department, workerSalary))
                .isEqualTo(expected);

        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> employeeService.addEmployee(firstName, lastName, department, workerSalary));

    }


    @Test
    void shouldReturnResultWhenAddIncorrectEmployeeName() {
        assertThatExceptionOfType(WrongNameException.class)
                .isThrownBy(() -> employeeService.addEmployee("Иван!", "Petrov^&", 2, 50000));

        assertThatExceptionOfType(WrongNameException.class)
                .isThrownBy(() -> employeeService.addEmployee("+Semen", "Ivanов*", 3, 20000));

        assertThatExceptionOfType(WrongNameException.class)
                .isThrownBy(() -> employeeService.addEmployee("Alexey-", "Степанов/", 4, 570000));
    }

    @ParameterizedTest
    @MethodSource("params")
    void shouldReturnResultWhenDeleteNullEmployee(String firstName,
                                                  String lastName,
                                                  int department,
                                                  int workerSalary) {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.deleteEmployee(
                        "Oleg",
                        "Kozlov"));

        Employee expected = new Employee(firstName, lastName, department, workerSalary);

        assertThat(employeeService.addEmployee(firstName, lastName, department, workerSalary))
                .isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.deleteEmployee(
                        "Oleg",
                        "Kozlov"));


    }

    @ParameterizedTest
    @MethodSource("params")
    void shouldReturnResultWhenDeleteEmployeeNullEmployee(String firstName,
                                                          String lastName,
                                                          int department,
                                                          int workerSalary) {

        Employee expected = new Employee(firstName, lastName, department, workerSalary);
        assertThat(employeeService.addEmployee(firstName, lastName, department, workerSalary))
                .isEqualTo(expected);
        assertThat(employeeService.deleteEmployee(firstName, lastName))
                .isEqualTo(expected);
        assertThat(employeeService.findAll()).isEmpty();

    }


    @ParameterizedTest
    @MethodSource("params")
    void shouldReturnResultWhenGetNullEmployee(String firstName,
                                               String lastName,
                                               int department,
                                               int workerSalary) {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.getEmployee(
                        "Oleg",
                        "Kozlov"));

        Employee expected = new Employee(firstName, lastName, department, workerSalary);

        assertThat(employeeService.addEmployee(firstName, lastName, department, workerSalary))
                .isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.getEmployee(
                        "Oleg",
                        "Kozlov"));
    }

    @ParameterizedTest
    @MethodSource("params")
    void shouldReturnResultWhenGetNewEmployee(String firstName,
                                              String lastName,
                                              int department,
                                              int workerSalary) {
        Employee expected = new Employee(firstName, lastName, department, workerSalary);
        assertThat(employeeService.addEmployee(firstName, lastName, department, workerSalary))
                .isEqualTo(expected);
        assertThat(employeeService.getEmployee(firstName, lastName))
                .isEqualTo(expected);
        assertThat(employeeService.findAll()).hasSize(1);

    }


    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("Ivan", "Petrov", 2, 50000),
                Arguments.of("Semen", "Ivanov", 3, 20000),
                Arguments.of("Alexey", "Stepanov", 4, 570000));
    }

}