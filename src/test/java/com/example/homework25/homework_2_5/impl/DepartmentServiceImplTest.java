package com.example.homework25.homework_2_5.impl;

import com.example.homework25.homework_2_5.data.Employee;
import com.example.homework25.homework_2_5.exceptions.EmployeeNotFoundException;
import com.example.homework25.homework_2_5.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void beforeEach() {
        List<Employee> employees = List.of(
                new Employee("Артас", "Менетил", 1, 26000),
                new Employee("Джайна", "Праудмур", 2, 15000),
                new Employee("Утер", "Светоносный", 2, 50000),
                new Employee("Сильвана", "Ветрокрылая", 3, 36000),
                new Employee("Иллидан", "Свирепый", 3, 40000),
                new Employee("Андуин", "Лотар", 2, 150000),
                new Employee("Громмаш", "Адский Крик", 1, 88000)
        );
        when(employeeService.findAll()).thenReturn(employees);
    }
    @ParameterizedTest
    @MethodSource("maxSalaryParams")
    public void maxSalaryFirstTest(int department, Employee expected) {
        assertThat(departmentService.departmentMaxSalary(department)).isEqualTo(expected);
    }

    @Test
    public void maxSalarySecondTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.departmentMaxSalary(8));
    }

    @ParameterizedTest
    @MethodSource("minSalaryParams")
    public void minSalaryFirstTest(int department, Employee expected) {
        assertThat(departmentService.departmentMinSalary(department)).isEqualTo(expected);
    }

    @Test
    public void minSalarySecondTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.departmentMinSalary(6));
    }

    @ParameterizedTest
    @MethodSource("departmentParams")
    public void departmentFirstTest(int department,List <Employee> expected) {
        assertThat(departmentService.departmentWorkers(department)).containsExactlyElementsOf(expected);
    }

    @Test
    public void departmentSecondTest() {
        assertThat(departmentService.allEmployee()).containsAllEntriesOf(Map.of(
                1, List.of(new Employee("Артас", "Менетил", 1, 26000),
                        new Employee("Громмаш", "Адский Крик", 1, 88000)),
2, List.of(new Employee("Джайна", "Праудмур", 2, 15000),
                                new Employee("Утер", "Светоносный", 2, 50000),
                                new Employee("Андуин", "Лотар", 2, 150000)),
                3, List.of( new Employee("Сильвана", "Ветрокрылая", 3, 36000),
                        new Employee("Иллидан", "Свирепый", 3, 40000))
        ));
    }


    public static Stream<Arguments> maxSalaryParams() {

        return Stream.of(
                Arguments.of(1, new Employee("Громмаш", "Адский Крик", 1, 88000)),
                Arguments.of(2, new Employee("Андуин", "Лотар", 2, 150000))
        );
    }

    public static Stream<Arguments> minSalaryParams() {
        return Stream.of(
                Arguments.of(2,new Employee("Джайна", "Праудмур", 2, 15000)),
                Arguments.of(3, new Employee("Сильвана", "Ветрокрылая", 3, 36000))
        );
    }

    public static Stream<Arguments> departmentParams() {
        return Stream.of(
                Arguments.of(1, List.of(new Employee("Артас", "Менетил", 1, 26000),
                        new Employee("Громмаш", "Адский Крик", 1, 88000))),
                Arguments.of(2, List.of(new Employee("Джайна", "Праудмур", 2, 15000),
                        new Employee("Утер", "Светоносный", 2, 50000),
                        new Employee("Андуин", "Лотар", 2, 150000))),
                Arguments.of(3, List.of( new Employee("Сильвана", "Ветрокрылая", 3, 36000),
                        new Employee("Иллидан", "Свирепый", 3, 40000))),
                Arguments.of(4, Collections.emptyList())
        );
    }
}