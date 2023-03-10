package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CageCreateDto {
    private String employeeId;
    private LocalDate createdDate;
    private LocalDate closedDate;
    private int quantity;

    @Override
    public String toString() {
        return "CageCreateDto{" +
                "employeeId='" + employeeId + '\'' +
                ", createdDate=" + createdDate +
                ", closedDate=" + closedDate +
                ", quantity=" + quantity +
                '}';
    }
}
