package com.example.demo;

import com.example.demo.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void login_Id_13() throws Exception{
        Account account = new Account();
        account.setAccountName(null);
        account.setPassword("12345");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_Id_14() throws Exception{
        Account account = new Account();
        account.setAccountName("");
        account.setPassword("12345");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_Id_15() throws Exception{
        Account account = new Account();
        account.setAccountName("**#$?001@@");
        account.setPassword("12345");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_Id_16() throws Exception{
        Account account = new Account();
        // min length = 3
        account.setAccountName("a");
        account.setPassword("12345");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_Id_17() throws Exception{
        Account account = new Account();
        // max length = 50
        account.setAccountName("yf5YEkz4IOxtUNtoo5KyIWT53JfpCzIIZA5Kpe6fMHVPDSfz5YTM");
        account.setPassword("12345");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_Id_18() throws Exception{
        Account account = new Account();
         account.setAccountName("admin");
        account.setPassword("12345");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
