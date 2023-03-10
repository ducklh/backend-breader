package com.example.demo.model.category;
import com.example.demo.model.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CatWard {
        @Id
        @Column(columnDefinition = "int",nullable = false)
        private int wardId;

        @Column(columnDefinition = "VARCHAR(50)")
        @NotBlank
        private String wardName;

        @Column(columnDefinition = "VARCHAR(50)")
        @NotBlank
        private String wardPrefix;

        @ManyToOne(targetEntity = CatDistrict.class)
        @JoinColumn(name = "district_id",nullable = false,columnDefinition = "int")
        private CatDistrict district;

        @ManyToOne(targetEntity = CatProvince.class)
        @JoinColumn(name = "province_id",nullable = false,columnDefinition = "int")
        private CatProvince province;

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "ward", cascade = CascadeType.REMOVE)
        @JsonBackReference(value = "WardToCustomer")
        private Set<Customer> customers;

        public CatWard(int wardId,String wardName,String wardPrefix) {
                this.wardId = wardId;
                this.wardName = wardName;
                this.wardPrefix = wardPrefix;
        }
}
