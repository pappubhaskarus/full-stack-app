package com.fullstack.employee.services;

import com.fullstack.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee updateEmployees(long id, Employee employee);

    void deleteEmployees(long id);
}
