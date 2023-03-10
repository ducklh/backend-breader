package com.example.demo;

import com.example.demo.model.Entities;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class EntitiesRestController_updateEntitties {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void updateEntities_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/entities/update/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/entities/update/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/entities/update/{id}","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/entities/update/{id}","12354"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void updateEntities_Id_19() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId(null);
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void updateEntities_Id_20() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Id_21() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("**001@@");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Id_22() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("1");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Id_23() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("123456789123123");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Id_24() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void updateEntities_InDate_19() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        entities.setInDate(null);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEntities_InDate_20() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(0,0,0);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_InDate_21() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,20,40);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_InDate_23() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,30);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_InDate_22() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("123456789123123");
        LocalDate inDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth());
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_InDate_24() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void updateEntities_OutDate_19() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        entities.setOutDate(null);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEntities_OutDate_20() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(0,0,0);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_OutDate_21() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,20,40);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_OutDate_22() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,30);
        entities.setInDate(inDate);
        entities.setOutDate(inDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_OutDate_24() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/Ga1234")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void updateEntities_Weight_19() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(Float.parseFloat(null));
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEntities_Weight_20() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(Float.parseFloat(""));
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Weight_21() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,20,40);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(Float.parseFloat("abc"));
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Weight_22() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,30);
        entities.setInDate(inDate);
        entities.setOutDate(inDate);
        entities.setStatus("Khoe");
        entities.setWeight(0);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Weight_23() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,30);
        entities.setInDate(inDate);
        entities.setOutDate(inDate);
        entities.setStatus("Khoe");
        entities.setWeight(9999);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Weight_24() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void updateEntities_Status_19() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus(null);
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEntities_Status_20() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Status_21() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,20,40);
        entities.setOutDate(outDate);
        entities.setStatus("123456");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Status_22() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,30);
        entities.setInDate(inDate);
        entities.setOutDate(inDate);
        entities.setStatus("a");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Status_23() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,30);
        entities.setInDate(inDate);
        entities.setOutDate(inDate);
        //entities.setStatus("abcdef");
        entities.setWeight(9999);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEntities_Status_24() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateEntities_IsDelete_19() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(null);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEntities_IsDelete_20() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,20);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(Boolean.parseBoolean(""));
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    @Test
//    public void updateEntities_IsDelete_21() throws Exception {
//        Entities entities = new Entities();
//        entities.setEntitiesId("Ga1234");
//        LocalDate inDate = LocalDate.of(2021,10,20);
//        entities.setInDate(inDate);
//        LocalDate outDate = LocalDate.of(2021,20,40);
//        entities.setOutDate(outDate);
//        entities.setStatus("Khoe");
//        entities.setWeight(10);
//        entities.setDelete();
//        entities.setCageId("1");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/entities/update/{id}")
//                        .content(this.objectMapper.writeValueAsString(entities))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void updateEntities_IsDelete_22() throws Exception {
//        Entities entities = new Entities();
//        entities.setEntitiesId("Ga1234");
//        LocalDate inDate = LocalDate.of(2021,10,30);
//        entities.setInDate(inDate);
//        entities.setOutDate(inDate);
//        entities.setStatus("Khoe");
//        entities.setWeight(10);
//        entities.setDelete(false);
//        entities.setCageId("1");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/entities/update/{id}")
//                        .content(this.objectMapper.writeValueAsString(entities))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void updateEntities_IsDelete_23() throws Exception {
//        Entities entities = new Entities();
//        entities.setEntitiesId("Ga1234");
//        LocalDate inDate = LocalDate.of(2021,10,30);
//        entities.setInDate(inDate);
//        entities.setOutDate(inDate);
//        entities.setStatus("Khoe");
//        entities.setWeight(9999);
//        entities.setDelete(false);
//        entities.setCageId("1");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/entities/update/{id}")
//                        .content(this.objectMapper.writeValueAsString(entities))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
    @Test
    public void updateEntities_IsDelete_24() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/entities/update/{id}")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
