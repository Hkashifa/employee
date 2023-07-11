package com.example.employee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {


    private Long id;
    private String CreatedBy;
    private Date CreatedAt;
    private String UpdatedBy;
    private Date UpdatedAt;
}
