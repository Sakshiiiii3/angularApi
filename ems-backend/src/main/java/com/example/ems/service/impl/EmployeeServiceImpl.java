/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.mapper.EmployeeMapper;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;

import lombok.AllArgsConstructor;
/**
 *
 * @author ATS
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

   private final  EmployeeRepository employeeRepository;

    @Override
   public EmployeeDto createEmployee(EmployeeDto employeeDto){

    Employee employee  = EmployeeMapper.mapToEmployee(employeeDto);
  Employee savedEmployee = employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(savedEmployee);
   }

   @Override
   public EmployeeDto getEmployeeById(Long employeeId){
    Employee employee = employeeRepository.findById(employeeId)
    .orElseThrow(() -> new ResourceNotFoundException("Employee doesnt exist with id" + employeeId));
   return EmployeeMapper.mapToEmployeeDto(employee);
}

   @Override
   public List<EmployeeDto> getAllEmployees(){
    List<Employee> employees = employeeRepository.findAll();
    return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
    .collect(Collectors.toList());
   }

   @Override
   public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee){
    Employee employee = employeeRepository.findById(employeeId).orElseThrow(
    () -> new ResourceNotFoundException("Employee doent exist with id" + employeeId)
   );
   employee.setFirstName(updatedEmployee.getFirstName());
   employee.setLastName(updatedEmployee.getLastName());
   employee.setEmail(updatedEmployee.getEmail());

  Employee updatedEmployeeObj = employeeRepository.save(employee);
  return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
}
@Override
public void  deleteEmployee(Long employeeId){
    Employee employee = employeeRepository.findById(employeeId).orElseThrow(
    () -> new ResourceNotFoundException("Employee doent exist with id" + employeeId)
   );
   employeeRepository.deleteById(employeeId);
}
}
