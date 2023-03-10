package com.example.demo.model;

import com.example.demo.customUtilities.CustomGenerateId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;
import org.hibernate.annotations.Parameter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cages_seq")
    @GenericGenerator(
            name = "cages_seq",
            strategy = "com.example.demo.customUtilities.CustomGenerateId",
            parameters = {
                    @Parameter(name = CustomGenerateId.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomGenerateId.PREFIX_PARAM_VALUE, value = "CN"),
                    @Parameter(name = CustomGenerateId.NUMBER_FORMAT_PARAMETER, value = "%03d")})
    @Column(columnDefinition = "VARCHAR(255)")
    private String cageId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate closedDate;

    @Min(value = 1, message = "quantity must greater than 1")
    @Max(value = 50,  message = "quantity must less than 50")
    @NotNull
    private int quantity;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cage", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "JsonBackEntities")
    private Set<Entities> entities;

    @Override
    public String toString() {
        return "Cage{" +
                "cageId='" + cageId + '\'' +
                ", createdDate=" + createdDate +
                ", closedDate=" + closedDate +
                ", quantity=" + quantity +
                ", employee=" + employee +
                ", entities=" + entities +
                '}';
    }
}
