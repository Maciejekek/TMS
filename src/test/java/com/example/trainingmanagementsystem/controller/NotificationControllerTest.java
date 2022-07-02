package com.example.trainingmanagementsystem.controller;

import org.hamcrest.Matchers;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
                .andExpect(jsonPath("$[0].id").doesNotExist())
                .andExpect(jsonPath("$[0].className").doesNotExist())
                .andExpect(jsonPath("$[0].description").doesNotExist());

    }

    //TODO - check later
    @Test
    @DisplayName("Should create Notification")
    void shouldCreateNotification() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/notifications?courseId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "date" : "2015-01-01"
                                "className" : "class1"
                                "description" : "des1"
                                }
                                """)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    //TODO - check later2
    @Test
    @DisplayName("Should update notification")
    void shouldUpdateNotification() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/notifications/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "date" : "2015-01-01"
                                "className" : "class1"
                                "description" : "des1"
                                }
                                """)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //TODO - check later3
    @Test
    @DisplayName("Should delete notification")
    void deleteNotification() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/notifications/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}