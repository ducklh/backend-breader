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

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationRestontroller_createNotification {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void createNotification_Id_13() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId(null);
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/admin/notification/create")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNotification_Id_14() throws Exception {
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
                        .post("/admin/notification/create")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createNotification_Id_15() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("L01");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/admin/notification/create")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createNotification_Id_16() throws Exception {
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
                        .post("/admin/notification/create")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createNotification_Id_17() throws Exception {
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
                        .post("/admin/notification/create")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEntities_Id_18() throws Exception {
        Notification notification = new Notification();
//        notification.setNotificationId("3");
        notification.setContent("Hoa An");
//        employee.setAccountId();
        LocalDate birthday = LocalDate.of(1998, 10, 20);
        notification.setUploadDate(birthday);
        notification.setImage("abc");
        notification.setDelete(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/admin/notification/create")
                        .content(this.objectMapper.writeValueAsString(notification))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
