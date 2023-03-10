package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEditDTO {
    String employeeId;
    String employeeName;
    String email;
    String avatar;
    LocalDate birthday;
    String gender;
    String idCard;
    String address;
    String account;
}
