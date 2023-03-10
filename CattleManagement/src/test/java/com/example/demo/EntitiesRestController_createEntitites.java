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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EntitiesRestController_createEntitites {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
@Test
public void createEntities_Id_13() throws Exception {
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
                    .post("/entities/create")
                    .content(this.objectMapper.writeValueAsString(entities))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().is4xxClientError());
}

    @Test
    public void createEntities_Id_14() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Id_15() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Id_16() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Id_17() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Id_18() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("Ga1234");
        LocalDate inDate = LocalDate.of(2021,10,10);
        entities.setInDate(inDate);
        LocalDate outDate = LocalDate.of(2021,10,20);
        entities.setOutDate(outDate);
        entities.setStatus("Khoe");
        entities.setWeight(10);
        entities.setDelete(false);
        entities.setCageId("2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void createEntities_InDate_13() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEntities_InDate_14() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_InDate_15() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_InDate_17() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_InDate_16() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_InDate_18() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void createEntities_OutDate_13() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEntities_OutDate_14() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_OutDate_15() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_OutDate_16() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_OutDate_18() throws Exception {
        Entities entities = new Entities();
        entities.setEntitiesId("1234");
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void createEntities_Weight_13() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEntities_Weight_14() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Weight_15() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Weight_16() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Weight_17() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Weight_18() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void createEntities_Status_13() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEntities_Status_14() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Status_15() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Status_16() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Status_17() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Status_18() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createEntities_IsDelete_13() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEntities_IsDelete_14() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//    @Test
//    public void createEntities_IsDelete_15() throws Exception {
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
//                        .post("/entities/create")
//                        .content(this.objectMapper.writeValueAsString(entities))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEntities_IsDelete_16() throws Exception {
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
//                        .post("/entities/create")
//                        .content(this.objectMapper.writeValueAsString(entities))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEntities_IsDelete_17() throws Exception {
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
//                        .post("/entities/create")
//                        .content(this.objectMapper.writeValueAsString(entities))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
    @Test
    public void createEntities_IsDelete_18() throws Exception {
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
                        .post("/entities/create")
                        .content(this.objectMapper.writeValueAsString(entities))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
