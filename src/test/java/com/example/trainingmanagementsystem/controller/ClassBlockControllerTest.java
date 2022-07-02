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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ClassBlockControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Should Create MockMvc")
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("Should get all class blocks")
    void shouldGetAllClassBlocks() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/classBlocks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.greaterThan(1)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @DisplayName("Should get class block by id ")
    void shouldGetClassBlockById() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/classBlocks?classBlockId=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should create new blok class")
    void shouldPostClassBlockWithCreated() throws Exception {

        this.mockMvc
                .perform(post("/classBlocks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name" : "name"}
                                """))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Should return http code 400 when json is bad")
    void shouldPostClassBlockThenHttpError400() throws Exception {

        this.mockMvc
                .perform(post("/classBlocks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name" : }
                                """))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    @DisplayName("Should Patch Classes By Id")
    void shouldPatchClassesBlockById() throws Exception {

        this.mockMvc
                .perform(post("/classBlocks?classBlockId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name" : "imie" }
                                """))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should delete Classes Box by Id ")
    void shouldDeleteClassBlockById() throws Exception {

        this.mockMvc
                .perform(delete("/classBlocks/?classBlockId=1&courseId=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        /* TODO - why?whyyyyyyyyyyyyy???
            log:
            org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint ["FKvpqxtuay01bo3jtvv8uijs5c: PUBLIC.courses_class_block_list FOREIGN KEY(class_block_list_id) REFERENCES PUBLIC.class_block(id) (CAST(1 AS BIGINT))"; SQL statement:
            delete from class_block where id=? [23503-214]]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
         */
    }
}

