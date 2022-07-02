package com.example.trainingmanagementsystem.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PersonNotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should Create MockMvc")
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }


    @Test
    @DisplayName("Should get all notifications ")
    void shouldGetAllNotifications() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/notification/user=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should get all read notifications")
    void shouldGetAllReadNotifications() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/notification/read/user=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Should get all not read notifications ")
    void getAllNotReadNotifications() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/notification/not-read/user=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}