package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralEntitiesService<T> {
    Page<T> findAll(Pageable pageable);
}
