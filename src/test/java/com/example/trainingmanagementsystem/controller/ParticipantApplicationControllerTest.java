package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.dto.ParticipantApplicationRequest;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ParticipantApplicationControllerTest {

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
    @DisplayName("Should create participant application ")
    void shouldCreateParticipantApplication() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/participantApplication")
                        .content(asJsonString(new ParticipantApplicationRequest(1L, 1L)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.personId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseId").value(1L));


    }

    @Test
    @DisplayName("Should get all participant application")
    void shouldGetAllParticipantApplication() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/participantApplication")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.size()", Matchers.anything()))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].personId").exists())
                .andExpect(jsonPath("$[0].courseId").exists())
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