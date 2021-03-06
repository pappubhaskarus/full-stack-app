package com.fullstack.employee.controller;

import com.fullstack.employee.model.Employee;
import com.fullstack.employee.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(
                employeeService.createEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }




    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployees(
            @PathVariable long id,
            @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployees(id, employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeesById(
            @PathVariable long id
             ) {
        return ResponseEntity.ok(employeeService.getEmployeesById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployees(
            @PathVariable long id) {
        employeeService.deleteEmployees(id);
        return ResponseEntity.accepted().build();
    }

}
