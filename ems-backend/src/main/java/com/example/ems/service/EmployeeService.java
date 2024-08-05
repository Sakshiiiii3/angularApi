/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.example.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ems.dto.EmployeeDto;
/**
 *
 * @author ATS
 */
@Service
public interface EmployeeService {
     EmployeeDto createEmployee(EmployeeDto employeeDto);
   
     EmployeeDto getEmployeeById(Long employeeId);

     List <EmployeeDto> getAllEmployees();

     EmployeeDto updateEmployee(Long employeeId,EmployeeDto employeeDto);

     void deleteEmployee(Long employeeId);
    }
