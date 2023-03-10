package com.example.demo.service;


import com.example.demo.model.Cage;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.CageForEditDto;
import com.example.demo.model.dto.EmployeeForCageDto;

import com.example.demo.model.dto.CageListDTO;
import com.example.demo.model.dto.GetEmployeeNameDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface CageService {

    List<String> getListCageId();
    Page<CageListDTO> findAllCage(Pageable pageable);
    Page<CageListDTO> findCageByCreatedDate(  String searchCageId,String employeeName, String dateFrom, String dateTo,Pageable pageable);
    Page<CageListDTO> findCageByCloseDate(String searchCageId, String employeeName, String dateFrom, String dateTo,Pageable pageable);
    List<GetEmployeeNameDTO> getAllEmployeeName();


    Cage save (Cage cage);

    Optional<Cage> findCageById(String id);

    Optional<CageForEditDto> findCageById2(String id);

    Boolean checkEmployee(String id);

    Boolean existsByCageId(String id);
    Integer getNextId();

    EmployeeForCageDto getEmployeeIdAndName(String accountName);

}
