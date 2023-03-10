package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EntitiesIllness {
    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    private String entitiesIllnessId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @Column(columnDefinition = "VARCHAR(255)")
    private String detailDescription;

    private Boolean isDelete;

    @ManyToOne(targetEntity = Entities.class)
    @JsonBackReference
    @JoinColumn(name = "entitiesId", referencedColumnName = "entitiesId")
    private Entities entities;


}
