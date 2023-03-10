package com.example.demo.service.impl;

import com.example.demo.model.Entities;
import com.example.demo.repository.EntitiesRepo;
import com.example.demo.service.EntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntitiesServiceImpl implements EntitiesService {
    @Autowired
    private EntitiesRepo entitiesRepo;

    public Page<Entities> findAll(Pageable pageable){
        return entitiesRepo.findAll(pageable);
    }

    @Override
    public Optional<Entities> findById(String id) {
        return entitiesRepo.findByEntitiesId(id);
    }
    public Entities save(Entities entities){
        return entitiesRepo.save(entities);
    }

    @Override
    public void deleteEntities(String id) {
        entitiesRepo.deleteEntities(id);
    }

    @Override
    public Page<Entities> findAllByInDateAndCage22(Pageable pageable,String inDate,String cage) {
        return entitiesRepo.findAllByInDateAndCage22(pageable,inDate,cage);
    }

    @Override
    public Page<Entities> findAllByInDateAndCage3(Pageable pageable, String inDateMin, String inDateMax, String cage) {
        System.out.println("Service-inDateMin: "+inDateMin);
        System.out.println("Service-inDateMax: "+inDateMax);
        return entitiesRepo.findAllByInDateAndCage3(pageable,inDateMin,inDateMax,cage);
    }
    public Integer getEntitiesId(String cageId) {
        return entitiesRepo.getEntitiesId(cageId);
    }

    @Override
    public void updateAutoRender(String cageId) {
        entitiesRepo.updateAutoRender(cageId);
    }
}
