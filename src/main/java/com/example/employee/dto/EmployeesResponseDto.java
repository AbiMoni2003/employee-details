package com.example.employee.dto;

import lombok.*;


@Data
@Getter
@Setter


public class EmployeesResponseDto {
    private String message;

    public EmployeesResponseDto(String message) {
        this.message = message;
    }
    }
