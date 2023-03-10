package com.example.demo.model;

import com.example.demo.customUtilities.GenerateCustomerId;
import com.example.demo.model.category.CatDistrict;
import com.example.demo.model.category.CatProvince;
import com.example.demo.model.category.CatWard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @Column(columnDefinition = "int")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int customerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    private String fullName;

    private String address;

    private String phone;

    private String email;

    private String message;

    private String comment;

    private Boolean gender;

    private Boolean status;

    private Boolean isDelete;

    @ManyToOne(targetEntity = CatProvince.class)
    @JoinColumn(name = "provinceId", referencedColumnName = "provinceId")
    private CatProvince province;

    @ManyToOne(targetEntity = CatDistrict.class)
    @JoinColumn(name = "districtId", referencedColumnName = "districtId")
    private CatDistrict district;

    @ManyToOne(targetEntity = CatWard.class)
    @JoinColumn(name = "wardId", referencedColumnName = "wardId")
    private CatWard ward;

//    @ManyToOne(targetEntity = Employee.class)
//    @JoinColumn(name = "employeeContact", referencedColumnName = "employeeId")
//    private Employee employeeContact;

}
