package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.repository.employeeRepository;
import com.example.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final employeeRepository EmployeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(employeeRepository employeeRepository, ModelMapper modelMapper) {
        this.EmployeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeEntity> all_employee;
        all_employee = employeeRepository.findAll();
        return all_employee.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO createEmployees(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeConverted = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeRepository.save(employeeConverted);

        EmployeeDTO employeeResponse = modelMapper.map(employeeConverted,EmployeeDTO.class);
        return employeeResponse;
    }

    @Override
    public EmployeeDTO updateEmployees(Long id, EmployeeDTO employeeDTO) {
        //Dto to entity
        EmployeeEntity employeeEntityResponse = modelMapper.map(employeeDTO, EmployeeEntity.class);
        Optional<  EmployeeEntity> updated_employee = employeeRepository.findById(id);

        if (updated_employee.isPresent()) {
            EmployeeEntity employee_entity = updated_employee.get();

            employee_entity.setFirstName(employeeEntityResponse.getFirstName());
            employee_entity.setLastName(employeeEntityResponse.getLastName());
            employee_entity.setEmail(employeeEntityResponse.getEmail());
            employee_entity.setPhoneNumber(employeeEntityResponse.getPhoneNumber());
            employee_entity.setEducation(employeeEntityResponse.getEducation());
            employee_entity.setJoinDate(employeeEntityResponse.getJoinDate());
            employee_entity.setPosition(employeeEntityResponse.getPosition());

            employeeRepository.save(employee_entity);//
            // entity to DTO
            EmployeeDTO employeeResponse = modelMapper.map(  employee_entity, EmployeeDTO.class);
            return employeeResponse;
        }
        return null;
    }

    @Override
    public EmployeeDTO deleteEmployees(long id, EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO getEmployeesById(long id) {
        return null;
    }
}
