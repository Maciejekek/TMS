package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.CourseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CourseServiceTest {

    @MockBean
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @Test
    @DisplayName("Should convert Class Block")
    void convertClassBlock() {

    }

    @Test
    void convertClasses() {
    }

    @Test
    void getCourseById() {
    }

    @Test
    void getCourseByPerson() {
    }

    @Test
    void addBlockInToCourse() {
    }

    @Test
    void addPersonInToCourse() {
    }

    @Test
    void deleteCourse() {
    }

    @Test
    void deleteBlockFromCourse() {
    }

    @Test
    void deletePersonFromCourse() {
    }

    @Test
    void editCourse() {
    }

    @Test
    void addCourse() {
    }

    @Test
    void addNotification() {
    }

    @Test
    void getCoursePersonList() {
    }
}