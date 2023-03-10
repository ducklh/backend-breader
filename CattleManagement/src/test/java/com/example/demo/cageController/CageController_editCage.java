package com.example.demo.cageController;
import com.example.demo.model.Cage;
import com.example.demo.model.Employee;
import com.example.demo.model.Entities;
import com.example.demo.model.dto.CageCreateDto;
import com.example.demo.service.impl.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class CageController_editCage {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    public void editCage_Id_13() throws Exception {
        Cage cage = new Cage();
        cage.setCageId(null);
        LocalDate createdDate = LocalDate.of(2022,5,11);
        cage.setCreatedDate(createdDate);
        LocalDate closedDate = LocalDate.of(2022,6,20);
        cage.setClosedDate(closedDate);
        cage.setQuantity(20);
        Employee employee = employeeService.findEmployeeById("N05");
        cage.setEmployee(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cage))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCage_Id_14() throws Exception {
        Cage cage = new Cage();
        cage.setCageId("");
        LocalDate createdDate = LocalDate.of(2022,5,11);
        cage.setCreatedDate(createdDate);
        LocalDate closedDate = LocalDate.of(2022,6,20);
        cage.setClosedDate(closedDate);
        cage.setQuantity(20);
        Employee employee = employeeService.findEmployeeById("N05");
        cage.setEmployee(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cage))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCage_Id_15() throws Exception {
        Cage cage = new Cage();
        cage.setCageId("**001@@");
        LocalDate createdDate = LocalDate.of(2022,5,11);
        cage.setCreatedDate(createdDate);
        LocalDate closedDate = LocalDate.of(2022,6,20);
        cage.setClosedDate(closedDate);
        cage.setQuantity(13);
        Employee employee = employeeService.findEmployeeById("N05");
        cage.setEmployee(employee);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cage))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCage_Id_18() throws Exception {
        CageCreateDto cageCreateDto = new CageCreateDto(
                "N05",
                LocalDate.of(2022,5,11),
                LocalDate.of(2022,6,20),
                13 );

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cageCreateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void editCage_CreatedDate_15() throws Exception {
        CageCreateDto cageCreateDto = new CageCreateDto(
                "N05",
                LocalDate.of(2022,4,5),
                LocalDate.of(2022,6,20),
                13 );

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cageCreateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCage_ClosedDate_15() throws Exception {
        CageCreateDto cageCreateDto = new CageCreateDto(
                "N05",
                LocalDate.of(2022,5,15),
                LocalDate.of(2022,4,20),
                13 );

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cageCreateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCage_Quantity_16() throws Exception {
        CageCreateDto cageCreateDto = new CageCreateDto(
                "N05",
                LocalDate.of(2022,5,15),
                LocalDate.of(2022,5,30),
                0 );

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cageCreateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCage_Quantity_17() throws Exception {
        CageCreateDto cageCreateDto = new CageCreateDto(
                "N05",
                LocalDate.of(2022,5,15),
                LocalDate.of(2022,5,30),
                55 );

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cageCreateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCage_Quantity_18() throws Exception {
        CageCreateDto cageCreateDto = new CageCreateDto(
                "N05",
                LocalDate.of(2022,5,15),
                LocalDate.of(2022,5,30),
                20 );

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create")
                        .content(this.objectMapper.writeValueAsString(cageCreateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
