/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ATS
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
     private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
