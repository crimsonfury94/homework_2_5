package com.example.homework25.homework_2_5.data;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int workersSalary;

    public Employee(String firstName, String lastName, int department, int workersSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.workersSalary = workersSalary;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getWorkersSalary() {
        return workersSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", workersSalary=" + workersSalary +
                '}';
    }
}
