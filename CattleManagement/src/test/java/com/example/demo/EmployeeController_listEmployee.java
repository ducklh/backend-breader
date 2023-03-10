package com.example.demo;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_listEmployee {

    @Autowired
    EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void getListStudent_1() {
//        ResponseEntity<Page<Employee>> responseEntity
//                = this.employeeController.listEmployee(PageRequest.of(0, 2), "");
//
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
<<<<<<< HEAD
//
=======

>>>>>>> cage
//    @Test
//    public void getListStudent_2() {
//        ResponseEntity<Page<Employee>> responseEntity
//                = this.employeeController.listEmployee(PageRequest.of(0, 2), "");
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("N02",
//                responseEntity.getBody().getContent().get(1).getEmployeeId());
//        Assertions.assertEquals("Trần Thuỳ My",
//                responseEntity.getBody().getContent().get(1).getEmployeeName());
//        Assertions.assertEquals(LocalDate.of(1999,12,30),
//                responseEntity.getBody().getContent().get(1).getBirthday());
//        Assertions.assertEquals("my@gmail.com",
//                responseEntity.getBody().getContent().get(1).getEmail());
//        Assertions.assertEquals("18992193",
//                responseEntity.getBody().getContent().get(1).getIdCard());
//        Assertions.assertEquals("false",
//                responseEntity.getBody().getContent().get(1).getGender());
//    }

    @Test
    public void getInfoStudent_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/list","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/list",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/list","Hoa An"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/list","Phạm Lê Khanh"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/list","Trần Thuỳ My"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("$.employeeId").value("N02"))
        .andExpect(jsonPath("$.email").value("my@gmail.com"))
        .andExpect(jsonPath("$.birthDay").value("1999-12-30"))
        .andExpect(jsonPath("$.gender").value(false));
    }


}
