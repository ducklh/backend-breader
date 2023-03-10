package com.example.demo.model.category;

import com.example.demo.model.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CatProvince {
        @Id
        @Column(columnDefinition = "int",nullable = false)
        private Integer provinceId;

        @Column(columnDefinition = "VARCHAR(50)")
        @NotBlank
        private String provinceName;

        @Column(columnDefinition = "VARCHAR(50)")
        @NotBlank
        private String provinceCode;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "province", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "ProvinceToDistrict")
    private Set<CatDistrict> districts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "province", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "ProvinceToWard")
    private Set<CatWard> wards;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "province", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "ProvinceToCustomer")
    private Set<Customer> customers;

    public Integer getProvinceId() {
        return provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

}
