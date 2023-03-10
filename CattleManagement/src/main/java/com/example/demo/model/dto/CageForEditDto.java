package com.example.demo.model.dto;

import java.time.LocalDate;

public interface CageForEditDto {
    String getCageId();
    String getEmployeeId();
    String getEmployeeName();
    LocalDate getClosedDate();
    LocalDate getCreatedDate();
    Integer getQuantity();

}
