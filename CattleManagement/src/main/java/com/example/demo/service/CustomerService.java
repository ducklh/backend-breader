package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.dto.CustomerCreateDTO;
import com.example.demo.model.dto.CustomerListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface CustomerService {
    void createCustomer(CustomerCreateDTO customer);
    Page<CustomerListDTO> getAllCustomer(Pageable pageable);
}

