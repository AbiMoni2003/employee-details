package com.example.employee.repository;

import com.example.employee.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,String> {
}
