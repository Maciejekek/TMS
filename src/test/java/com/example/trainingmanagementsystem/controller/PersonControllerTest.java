package com.example.trainingmanagementsystem.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PersonControllerTest {

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
    @DisplayName("Should get all person")
    void shouldGetAllPerson() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/persons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.greaterThan(1)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @DisplayName("Should get all person accountData")
    void getAllPersonAccountData() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/persons/accounts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.greaterThan(1)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].login").exists())
                .andExpect(jsonPath("$[0].password").exists())
                .andExpect(jsonPath("$[0].authToken").exists())
                .andExpect(jsonPath("$[0].email").exists())
                .andExpect(jsonPath("$[0].type").exists())
                .andExpect(jsonPath("$[0].isActive").exists());


    }

    @Test
    @DisplayName("Should get person by id ")
    void shouldGetPersonById() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/persons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should get person account data by id")
    void shouldGetPersonAccountDataById() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/persons/account/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should create person account data")
    void shouldCreatePersonAccountData() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/persons/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content()
                )

                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void createPerson() {
    }

    @Test
    void editPerson() {
    }

    @Test
    void editPersonAccountData() {
    }

    @Test
    void deletePerson() {
    }
}