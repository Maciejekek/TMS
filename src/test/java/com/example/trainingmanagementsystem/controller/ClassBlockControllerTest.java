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
                .andExpect(jsonPath("$.size()", Matchers.is(1)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @DisplayName("Should get class block by id ")
    void shouldGetClassBlockById() throws Exception {
        var id = 1L;

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/classBlocks/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").exists());
    }

    @Test
    @DisplayName("Should create new blok class")
    void shouldPostClassBlockWithCreated() throws Exception {

        this.mockMvc
                .perform(post("/classBlocks/addClassBlock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name" : "name"}
                                """))
                .andDo(print())
                .andExpect(status().isCreated()); // po utworzeniu zasobu nie zwracasz go, więc reszta sprawdzania nie ma sensu

    }

    @Test
    @DisplayName("Should return http code 400 when json is bad")
    void shouldPostClassBlockThenHttpError400() throws Exception {

        this.mockMvc
                .perform(post("/classBlocks/addClassBlock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name" : }
                                """))
                .andDo(print())
                .andExpect(status().is4xxClientError()); // po utworzeniu zasobu nie zwracasz go, więc reszta sprawdzania nie ma sensu

    }

//    @Test
//    void shouldPatchClasses() {
//        var id = 1L;
//
//        this.mockMvc
//                .perform(patch("/classBlocks/" + id));
//
//
//    }
//
//    @Test
//    void deleteClasses() {
//
//    }
}

