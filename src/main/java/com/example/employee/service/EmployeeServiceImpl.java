package com.example.employee.service;

import com.example.employee.dto.EmployeesRequestDto;
import com.example.employee.dto.EmployeesResponseDto;
import com.example.employee.entity.Employees;
import com.example.employee.facade.EmployeeFacade;
import com.example.employee.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    EmployeeFacade employeeFacade;

    @Override
    public EmployeesResponseDto createUser(EmployeesRequestDto reqDto) {
    return employeeFacade.createUser(reqDto);
    }
    @Override
    public List<Employees> getAllEmployees() {
    return employeesRepository.findAll();
    }
    @Override
    public Employees getEmployeeById(String employeeId) {
        Optional<Employees> employee = employeesRepository.findById(employeeId);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee Id " + employeeId + " is not here");
        }
    }
    @Override
    public String deleteEmployeeById(String employeeId) {
        Optional<Employees> employee = employeesRepository.findById(employeeId);
        if (employee.isPresent()) {
            employeesRepository.deleteById(employeeId);
            return "Employee  ID " + employeeId + " deleted";
        } else {
            throw new RuntimeException("Employee  ID " + employeeId + " is not here");
        }
    }
    @Override
    public String updateEmployeeById(String employeeId, Employees updatedEmploees) {
        return employeeFacade.updateEmployeeById(employeeId,updatedEmploees);
    }
}
