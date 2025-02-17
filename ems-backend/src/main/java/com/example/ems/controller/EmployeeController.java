package com.example.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Build add employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get employee
@GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")Long employeeId){
        EmployeeDto employeeDto  =employeeService.getEmployeeById(employeeId);
    return ResponseEntity.ok(employeeDto);
    }

    //get all employees
@GetMapping
public  ResponseEntity<List<EmployeeDto>> getAllEmployees(){
  List<EmployeeDto> employees =   employeeService.getAllEmployees();
  return ResponseEntity.ok(employees);
}

//update employee
@PutMapping("{id}")
public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")Long employeeId, 
@RequestBody EmployeeDto updatedEmployee){
    EmployeeDto employeeDto  = employeeService.updateEmployee(employeeId, updatedEmployee);
    return ResponseEntity.ok(employeeDto);
}

//delete 
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.ok("Employee deleted successfully");
} 
}

