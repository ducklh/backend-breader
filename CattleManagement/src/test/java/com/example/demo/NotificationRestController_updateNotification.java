package com.example.demo;

import com.example.demo.model.Notification;
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

@AutoConfigureMockMvc
@SpringBootTest
public class NotificationRestController_updateNotification {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateNotification_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/admin/notification/update/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/admin/notification/update/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/admin/notification/update/{id}", "L1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/admin/notification/update/{id}", "12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateNotification_Id_19() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/admin/notification/update/{id}")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_Id_20() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/admin/notification/update/{id}")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_Id_21() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("L1");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/admin/notification/update/{id}")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_Id_22() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("0");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/admin/notification/update/{id}")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_Id_23() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("123123");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/admin/notification/update/{id}")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateNotification_Id_24() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("2");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/admin/notification/update/{id}")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
