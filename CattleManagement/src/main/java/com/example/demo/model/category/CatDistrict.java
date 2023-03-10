package com.example.demo.model.category;
import com.example.demo.model.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.Set;

@Entity
public class CatDistrict {
        public CatDistrict() {
        }
        public CatDistrict(int districtId, String districtName, String districtPrefix) {
                this.districtId = districtId;
                this.districtName = districtName;
                this.districtPrefix = districtPrefix;
        }

        @Id
        @Column(columnDefinition = "int",nullable = false)
        private int districtId;

        @Column(columnDefinition = "VARCHAR(50)")
        @NotBlank
        private String districtName;

        @Column(columnDefinition = "VARCHAR(50)")
        @NotBlank
        private String districtPrefix;

        @ManyToOne(targetEntity = CatProvince.class)
        @JoinColumn(name = "provinceId",nullable = false,columnDefinition = "int")
        private CatProvince province;

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "district", cascade = CascadeType.REMOVE)
        @JsonBackReference(value = "DistrictToWard")
        private Set<CatWard> wards;

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "district", cascade = CascadeType.REMOVE)
        @JsonBackReference(value = "DistrictToCustomer")
        private Set<Customer> customers;

        public int getDistrictId() {
                return districtId;
        }


        public String getDistrictName() {
                return districtName;
        }

        public void setDistrictName(String districtName) {
                this.districtName = districtName;
        }

        public CatProvince getProvince() {
                return province;
        }

        public void setProvince(CatProvince province) {
                this.province = province;
        }
}
