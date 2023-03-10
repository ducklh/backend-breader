package com.example.demo.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface IGeneralNotificationService<T> {
    Page<T> findAll(Pageable pageable);
}