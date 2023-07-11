package com.example.employee.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity{


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String Email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "Education")
    private String Education;

    @Column(name = "joinDate")
    private Date joinDate;

    @Column(name = "position")
    private String position;
}
