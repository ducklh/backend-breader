//package com.example.demo.controller;
//import com.example.demo.model.dto.CageListDTO;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//@SpringBootTest
//public class TestListCage {
//    @Autowired
//    private CageController cageController;
//
//    @Test
//    public void testCageList_1(){
//        ResponseEntity<Page<CageListDTO>> responseEntity = this.cageController.findAllCage(PageRequest.of(0,2));
//
//        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
//    }
//}
//
//
//
//
//}
