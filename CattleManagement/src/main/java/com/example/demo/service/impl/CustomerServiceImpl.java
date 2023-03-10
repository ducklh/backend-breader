package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.model.dto.CustomerCreateDTO;
import com.example.demo.model.dto.CustomerListDTO;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public void createCustomer(CustomerCreateDTO customer) {
        customerRepo.createCustomer(customer.getFullName(),
                                    customer.getAddress(),
                                    customer.getPhone(),
                                    customer.getEmail(),
                                    customer.getGender(),
                                    customer.getMessage(),
                                    customer.getProvince(),
                                    customer.getDistrict(),
                                    customer.getWard(),
                                    customer.getCreateDate());
    }

    @Override
    public Page<CustomerListDTO> getAllCustomer(Pageable pageable) {
        return null;
    }
}
