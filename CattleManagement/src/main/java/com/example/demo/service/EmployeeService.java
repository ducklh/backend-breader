package com.example.demo.service;

import com.example.demo.model.dto.EmployeeDTO;
import com.example.demo.model.dto.EmployeeFindIdDTO;
import com.example.demo.model.dto.EmployeeListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import com.example.demo.model.Employee;

import com.example.demo.model.dto.EmployeeForCageDto;

import java.util.List;

public interface EmployeeService{
    Boolean existsByEmployeeId(String id);

    List<EmployeeForCageDto> getAllEmployee();

    Employee findEmpById(String id);
    Page<EmployeeListDTO> findAllEmployeeByNameAndId(String searchName, String searchId, Pageable pageable);
    Page<EmployeeListDTO> findAllEmployee(Pageable pageable);
    Optional<EmployeeFindIdDTO> findEmployeeById(String id);
    void editEmployee(EmployeeDTO EmployeeDTO);
    void createNewEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(String id);
    Integer getNextId();
    void updateAutoRender();
}
