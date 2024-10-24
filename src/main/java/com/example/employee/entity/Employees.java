package com.example.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employee_details")
public class Employees {
    @Id
    @Column(name = "employee_id",unique = true,nullable = false)
    private String employeeId;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "department",nullable = false)
    private String department;
    @Column(name = "designation",nullable = false)
    private String designation;
    @Column(name = "salary",nullable = false)
    private String Salary;
    @Column(name = "joining_data",nullable = false)
    private Date joiningDate;
}
