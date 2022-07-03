package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.Model.PersonAccountData;
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
                        .content(asJsonString(new PersonAccountData(1L, null, "login", "password", "token", "email@gmail.com", "type", true)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login").value("login"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("password"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authToken").value("token"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value("type"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isActive").value(true));


    }


    @Test
    @DisplayName("Should create Person")
    void shouldCreatePerson() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/persons")
                        .content(asJsonString(new Person(1l, "Jan", "Kowalski", null, null)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Jan"))
                .andExpect(jsonPath("$.lastName").value("Kowalski"));

    }

    @Test
    @DisplayName("Should edit Person")
    void shouldEditPerson() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.patch("/persons/1")
                        .content(asJsonString(new Person(1l, "Jan", "Kowalski", null, null)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Should edit person account data")
    void editPersonAccountData() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.patch("/persons//account/1")
                        .content(asJsonString(new PersonAccountData(1L, null, "login", "password", "token", "email@gmail.com", "type", true)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login").value("login"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("password"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authToken").value("token"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value("type"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isActive").value(true));

    }

    //TODO Entity must not be null!
    @Test
    @DisplayName("Should Delete Person")
    void shouldDeletePerson() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/persons/1")
                        .content(asJsonString(new Person(1l, "Jan", "Kowalski", null, null)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )

                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Jan"))
                .andExpect(jsonPath("$.lastName").value("Kowalski"));


    }
}