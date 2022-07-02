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
class ClassesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should Create MockMvc")
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("Should get all Classes")
    void shouldGetAllClasses() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/classes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.greaterThan(1)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].topic").exists());

    }

    @Test
    @DisplayName("Should get classes by id")
    void shouldGetClassesById() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/classes/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should add new  Class")
    void shouldAddClasses() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/classes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "topic" : "topic"
                                }
                                """)

                )
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Should edit class by id")
    void shouldEditClassesById() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/classes?classesId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "topic" : "newTopic"
                                }
                                """)
                )

                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Should delete Class by Id")
    void shouldDeleteClassesById() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/classes?classesId=1&blockId=1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}