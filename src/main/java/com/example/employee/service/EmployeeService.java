package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface  EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO createEmployees(EmployeeDTO employeeDTO);

    public EmployeeDTO updateEmployees(Long id, EmployeeDTO employeeDTO);

    public EmployeeDTO deleteEmployees(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeesById(long id);
}
