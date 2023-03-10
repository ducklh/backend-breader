package com.example.demo.service;

import com.example.demo.model.Entities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EntitiesService extends IGeneralEntitiesService<Entities> {
    Page<Entities> findAll(Pageable pageable);
    Optional<Entities> findById(String id);
    Entities save(Entities entities);
    void deleteEntities(String id);
    Page<Entities> findAllByInDateAndCage22(Pageable pageable,String inDate,String cage);
    Integer getEntitiesId(String cageId);
    void updateAutoRender(String cageId);
    Page<Entities> findAllByInDateAndCage3(Pageable pageable,String inDateMin,String inDateMax,String cage);
}
