package com.example.employee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {


    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String Education;
    private Date joinDate;
    private String position;
}
