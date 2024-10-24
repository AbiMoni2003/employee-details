package com.example.employee.service;

import com.example.employee.dto.EmployeesRequestDto;
import com.example.employee.dto.EmployeesResponseDto;
import com.example.employee.entity.Employees;
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

    @Override
    public EmployeesResponseDto createUser(EmployeesRequestDto reqDto) {
        Employees employees = reqDto.getEmployees();
        if (employees.getEmployeeId().length() != 3) {
            return new EmployeesResponseDto("Id must be exactly 3 digits");
        }
        if (employees.getName().matches("\\d+")||employees.getName().isEmpty()) {
            return new EmployeesResponseDto("Give a proper name");
        }
        if (employees.getDepartment().matches("\\d+")||employees.getDepartment().isEmpty()) {
            return new EmployeesResponseDto("Give a proper value to Department.");
        }
        if (employees.getDesignation().isEmpty()||employees.getDesignation().matches("\\d+")) {
            return new EmployeesResponseDto("Give a proper value to Designation");
        }
        if (employees.getSalary().isEmpty()) {
            return new EmployeesResponseDto("Employee Salary is empty");
        }
        try {
            Integer.parseInt(employees.getSalary());
        } catch (NumberFormatException e) {
            return new EmployeesResponseDto("Employee Salary should be integer");
        }
        if (employees.getJoiningDate() == null) {
            return new EmployeesResponseDto("Employee Joining Date is empty");
        }
        Date currentDate = new Date(); // This gives the current date and time
        if (employees.getJoiningDate().after(currentDate)) {
            return new EmployeesResponseDto("This Date is not valid");
        }
        try {
            Integer employeeId = Integer.parseInt(employees.getEmployeeId());
            if (employeesRepository.existsById(String.valueOf(employeeId))) {
                return new EmployeesResponseDto("Error: Employee_Id already exists");
            }
        } catch (NumberFormatException e) {
            return new EmployeesResponseDto("Id must be an integer");
        }
        try {
            employeesRepository.save(employees);
            return new EmployeesResponseDto("Employee Details Added Successfully");
        } catch (Exception e) {
            return new EmployeesResponseDto("Error: " + e.getMessage());
        }
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
        Optional<Employees> employeeOptional = employeesRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employees existingEmployee = employeeOptional.get();
            if(updatedEmploees.getName().length()<3) {
                throw new RuntimeException(" Error: Write Your Full Name");
            }
            if ( updatedEmploees.getEmployeeId().isEmpty()) {
                return "Employee ID is empty";
            }
            if ( updatedEmploees.getName().isEmpty()||updatedEmploees.getName().matches("\\d+")) {
                return "Give a proper name";
            }
            if ( updatedEmploees.getDepartment().isEmpty()||updatedEmploees.getDepartment().matches("\\d+")) {
                return "Give a proper value to department";
            }
            if (updatedEmploees.getDesignation().isEmpty()||updatedEmploees.getDesignation().matches("\\d+")) {
                return "Give a proper value to designation";
            }
            if (updatedEmploees.getSalary().isEmpty()) {
                return "Employee Salary is empty";
            }
            try {
                Integer.parseInt(updatedEmploees.getSalary());
            } catch (NumberFormatException e) {
                return "Employee Salary should be integer";
            }
            if (updatedEmploees.getJoiningDate() == null) {
                return "Employee Joining Date is empty";
            }
            Date currentDate = new Date();
            if (updatedEmploees.getJoiningDate().after(currentDate)) {
                return "This date is not valid";
            }
            existingEmployee.setName(updatedEmploees.getName());
            existingEmployee.setDepartment(updatedEmploees.getDepartment());
            existingEmployee.setDesignation(updatedEmploees.getDesignation());
            existingEmployee.setSalary(updatedEmploees.getSalary());
            existingEmployee.setJoiningDate(updatedEmploees.getJoiningDate());
            employeesRepository.save(existingEmployee);
            return "Employee details updated successfully.";
        } else {
            throw new RuntimeException("Employee with ID " + employeeId + " is not found.");
        }
    }
}
