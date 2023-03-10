package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AutoId {
    @Id
    @Column(columnDefinition = "VARCHAR(255)",nullable = false)
    private String AutoId;

    @Column(columnDefinition = "VARCHAR(255)")
    @NotBlank
    private String typeCode;

    @Column(columnDefinition = "VARCHAR(255)")
    @NotBlank
    private String groupCode;

    private int current_index;


}
