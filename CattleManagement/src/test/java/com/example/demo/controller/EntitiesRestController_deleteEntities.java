package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EntitiesRestController_deleteEntities {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void editIsDelete_id_25() throws Exception{
            this.mockMvc.perform(
                            MockMvcRequestBuilders.get("/entities/delete/{id}","null"))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }
    @Test
    public void editIsDelete_id_26() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/entities/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editIsDelete_id_27() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/entities/delete/{id}","123123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editIsDelete_id_28() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/entities/delete/{id}","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



}
