package com.example.demo;

import com.example.demo.model.Employee;
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
public class EmployeeController_updateEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateEmployee_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/update/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/update/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/update/{id}","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/update/{id}","12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateEmployee_Id_1() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(null);
        employee.setEmployeeName("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998,10,20);
        employee.setBirthday(birthday);
        employee.setGender("true");
        employee.setGender("19459801");
        employee.setGender("DN");
        employee.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_Id_2() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId("");
        employee.setEmployeeName("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998,10,20);
        employee.setBirthday(birthday);
        employee.setGender("true");
        employee.setGender("19459801");
        employee.setGender("DN");
        employee.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_Id_3() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId("001");
        employee.setEmployeeName("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998,10,20);
        employee.setBirthday(birthday);
        employee.setGender("true");
        employee.setGender("19459801");
        employee.setGender("DN");
        employee.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_Id_4() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId("@#2134");
        employee.setEmployeeName("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998,10,20);
        employee.setBirthday(birthday);
        employee.setGender("true");
        employee.setGender("19459801");
        employee.setGender("DN");
        employee.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_Id_5() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId("HoaAn@Gmail.com");
        employee.setEmployeeName("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998,10,20);
        employee.setBirthday(birthday);
        employee.setGender("true");
        employee.setGender("19459801");
        employee.setGender("DN");
        employee.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_Id_6() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId("1");
        employee.setEmployeeName("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998,10,20);
        employee.setBirthday(birthday);
        employee.setGender("true");
        employee.setGender("19459801");
        employee.setGender("DN");
        employee.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_Id_7() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId("N01");
        employee.setEmployeeName("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998,10,20);
        employee.setBirthday(birthday);
        employee.setGender("true");
        employee.setGender("19459801");
        employee.setGender("DN");
        employee.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
