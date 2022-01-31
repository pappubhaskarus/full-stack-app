package com.fullstack.employee.services;

import com.fullstack.employee.entity.EmployeeEntity;
import com.fullstack.employee.model.Employee;
import com.fullstack.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        return mapEmployeeEntityToPOJO(employeeRepository.save(employeeEntity));
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employeeList = employeeEntities.stream().map(this::mapEmployeeEntityToPOJO).collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public Employee updateEmployees(long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        return mapEmployeeEntityToPOJO(employeeRepository.save(employeeEntity));
    }

    @Override
    public void deleteEmployees(long id) {
        employeeRepository.deleteById(id);
    }

    private Employee mapEmployeeEntityToPOJO(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

}
