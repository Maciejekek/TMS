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
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/course"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.greaterThan(1)))
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @DisplayName("Should add new course")
    void shouldAddNewCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                 "name" : "java"
                                }
                                """)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should get Course by Person by Id")
    void shouldGetCourseByPersonById() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/course?personId=1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Should get course by id")
    void shouldGetCourseById() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/course/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should get Course Person List")
    void shouldGetCoursePersonList() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/course/personList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "name" : "java"
                                }
                                """)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should add Block in to course")
    void shouldAddBlockInToCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/course?courseId=1&blockId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "personId" : "1L"
                                }
                                """)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should add Person in to course")
    void shouldAddPersonInToCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/course/addPerson?courseId=1&personId=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should edit course")
    void shouldEditCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.patch("/course/edit?courseId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "name" : "C"
                                }
                                """)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should delete Person From Course ")
    void shouldDeletePersonFromCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/course/deletePerson?courseId=1&personId=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Should delete Block From Course")
    void deleteBlockFromCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/course/deleteBlock?courseId=1&blockId=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Should delete course")
    void shouldDeleteCourse() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/course?courseId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}