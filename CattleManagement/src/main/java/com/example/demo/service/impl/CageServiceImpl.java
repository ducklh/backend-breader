package com.example.demo.service.impl;


import com.example.demo.customUtilities.CageComparator;
import com.example.demo.model.Cage;
import com.example.demo.model.Employee;
import com.example.demo.model.Entities;
import com.example.demo.model.dto.CageForEditDto;
import com.example.demo.model.dto.EmployeeForCageDto;

import com.example.demo.model.Cage;
import com.example.demo.model.dto.CageListDTO;
import com.example.demo.model.dto.GetEmployeeNameDTO;
import com.example.demo.repository.CageRepo;
import com.example.demo.service.CageService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CageServiceImpl implements CageService {
    @Autowired
    private CageRepo cageRepo;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<String> getListCageId() {
        return cageRepo.getListCageId();
    }

    @Override
    public Cage save(Cage cage) {
        return cageRepo.save(cage);
    }

    @Override
    public Optional<Cage> findCageById(String id) {
        return cageRepo.findByCageId(id);
    }

    @Override
    public Optional<CageForEditDto> findCageById2(String id) {
        return cageRepo.findByCageId2(id);
    }

    @Override
    public Boolean checkEmployee(String id) {
        return employeeService.existsByEmployeeId(id);
    }

    @Override
    public Boolean existsByCageId(String id) {
        return cageRepo.existsByCageId(id);
    }



    @Override
    public Integer getNextId() {
        return cageRepo.getNextId();
    }

    @Override
    public EmployeeForCageDto getEmployeeIdAndName(String accountName) {
        return cageRepo.getEmployeeIdAndName(accountName);
    }

    public Boolean isValidDate(Cage cage){
        return  (cage.getCreatedDate().isEqual(LocalDate.now()) || cage.getCreatedDate().isAfter(LocalDate.now()))
                && cage.getClosedDate().isAfter(cage.getCreatedDate());
    }

    public void autoUpdateClosedDate(Cage cage,Entities entities) {
        LocalDate maxDate=cage.getClosedDate();
        LocalDate entitiesDate=entities.getOutDate();
        System.out.println(maxDate.toString());
        System.out.println(entitiesDate.toString());
        System.out.println(entities.getCageId());
        if(entitiesDate.isAfter(maxDate)){
            cageRepo.updateClosedDate(entitiesDate,cage.getCageId());
        }
    }

    public Page<CageListDTO> findAllCage(Pageable pageable) {
        return cageRepo.findAllCage(pageable);
    }

    public Integer getEntitiesInCage(String cageId){
        return cageRepo.getEntitiesInCage(cageId);
    }
    @Override
    public Page<CageListDTO> findCageByCreatedDate( String searchCageId,String employeeId,String dateFrom, String dateTo,Pageable pageable) {
        return cageRepo.findCageByCreatedDate(searchCageId,employeeId,dateFrom,dateTo,pageable);
    }

    @Override
    public Page<CageListDTO> findCageByCloseDate(String searchCageId,String employeeId, String dateFrom, String dateTo, Pageable pageable) {
        return cageRepo.findCageByClosedDate(searchCageId,employeeId,dateFrom,dateTo,pageable);

    }
    @Override
    public List<GetEmployeeNameDTO> getAllEmployeeName() {
        return cageRepo.getAllEmployeeName();
    }

}

