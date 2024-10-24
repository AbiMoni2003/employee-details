package com.example.employee.service;

import com.example.employee.dto.EmployeesRequestDto;
import com.example.employee.dto.EmployeesResponseDto;
import com.example.employee.entity.Employees;

import java.util.List;

public interface EmployeeService {
    EmployeesResponseDto createUser(EmployeesRequestDto reqDto);
    List<Employees> getAllEmployees();
    Employees getEmployeeById(String employeeId);
    String deleteEmployeeById(String employeeId);
    String updateEmployeeById(String employeeId, Employees updatedEmploees);
}
