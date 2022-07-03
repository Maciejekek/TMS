package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Should Create MockMvc")
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    //TODO change test when we add the records!
    @Test
    @DisplayName("Should get All notifications")
    void shouldGetAllNotifications() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/notifications")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.anything()))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].className").exists())
                .andExpect(jsonPath("$[0].description").exists());
    }

    //TODO - detached entity passed to persist
    @Test
    @DisplayName("Should create Notification")
    void shouldCreateNotification() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/notifications?courseId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                            "date": "2022-07-08",
                            "className": "Petle",
                            "description": "nie bylo latwo"
                            }
                            """))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should update notification")
    void shouldUpdateNotification() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/notifications/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                            "date": "2022-07-09",
                            "className": "Petle",
                            "description": "nie bylo latwo"
                            }
                            """))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Should delete notification")
    void shouldDeleteNotification() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/notifications/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}