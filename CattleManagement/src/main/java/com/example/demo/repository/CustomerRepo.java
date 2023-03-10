package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.dto.CustomerCreateDTO;
import com.example.demo.model.dto.CustomerListDTO;
import com.example.demo.model.dto.DistrictListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Transactional
    @Modifying
    @Query(value="INSERT INTO customer(full_name,address,phone,email,gender,message,province_id,district_id,ward_id,created_date)" +
            " values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery=true)
    void createCustomer(String fullName, String address, String phone, String email,
                        Boolean gender, String message, int province, int district, int ward,String createDate);

//    @Query(value="INSERT INTO customer(full_name,address,phone,email,gender,message,province_id,district_id,ward_id)" +
//            " values(?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery=true)
//    Page<CustomerListDTO> findAllCustomer();
}
