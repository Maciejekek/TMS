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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ParticipantApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should create participant application ")
    void shouldCreateParticipantApplication() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/participantApplication?courseId=1&personId=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    @DisplayName("Should get all participant application")
    void shouldGetAllParticipantApplication() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/participantApplication")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.size()", Matchers.anything()))
                .andExpect(jsonPath("$[0].id").doesNotExist())
                .andExpect(jsonPath("$[0].personId").doesNotExist())
                .andExpect(jsonPath("$[0].courseId").doesNotExist())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    @DisplayName("Should get Participant Application By Id ")
    void shouldGetParticipantApplicationById() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/participantApplication/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Should accept participant application")
    void shouldAcceptParticipantApplication() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/participantApplication/accept?applicationId=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Should decline participant application")
    void shouldDeclineParticipantApplication() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/participantApplication/decline?applicationId=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}