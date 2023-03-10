package com.example.demo.model.dto;

import com.example.demo.customUtilities.CustomGenerateId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    String employeeId;
    String employeeName;
    String avatar;
    String email;
    String birthday;
    String gender;
    String idCard;
    String address;
    boolean isDelete;
    Long accountId;
    String accountName;
    String password;
}
