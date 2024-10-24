package com.example.employee.controller;

import com.example.employee.dto.EmployeesRequestDto;
import com.example.employee.dto.EmployeesResponseDto;
import com.example.employee.entity.Employees;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("create")
    public ResponseEntity<EmployeesResponseDto> createEmployee(@RequestBody EmployeesRequestDto reqDto) {
        EmployeesResponseDto response = employeeService.createUser(reqDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("getall")
    public ResponseEntity<List<Employees>> getAllEmployees() {
        List<Employees> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("get/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String employeeId) {
        try {
            Employees employee = employeeService.getEmployeeById(employeeId);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @DeleteMapping("delete/{employeeId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable String employeeId) {
        try {
            String responseMessage = employeeService.deleteEmployeeById(employeeId);
            return ResponseEntity.ok(responseMessage);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PutMapping("update/{employeeId}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable String employeeId, @RequestBody Employees updatedEmployee) {
        try {
            String updated = employeeService.updateEmployeeById(employeeId, updatedEmployee);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
