package com.example.demo.controller;

import com.example.demo.model.Entities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class EntitiesRestController_getListEntities {
    @Autowired
    private EntitiesController entitiesController;
    @Test
    public void getListEntities_5() {

        ResponseEntity<Page<Entities>> responseEntity
                = this.entitiesController.findAllEntities(PageRequest.of(0,2));

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListStudent_6() {
        ResponseEntity<Page<Entities>> responseEntity
                = this.entitiesController.findAllEntities(PageRequest.of(0, 2));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getEntitiesId());
        LocalDate date = LocalDate.of(2022,01,02);
        Assertions.assertEquals(date,
                responseEntity.getBody().getContent().get(0).getInDate());
    }
}
