package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    private Long roleId;

    @Column(columnDefinition = "VARCHAR(50)")
    private String roleName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "RoleBackToRoleSet")
    private Set<AccountRole> roleSet;
}
