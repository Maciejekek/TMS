package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    private static final Course COURSE = new Course(1L, "name", null, null, null);
    private static final ClassBlock CLASS_BLOCK = new ClassBlock(1l, "name");
    private static final Person PERSON = new Person(null, 1l, "login", "password", "type", "name", "lastName", true);

    @Mock
    private CourseService courseService;

    @Test
    void getAllCourse() {
        courseService.findAll();
    }

    @Test
    void getCourseByPersonId() {
        courseService.getCourseByPersonId(COURSE.getId());
    }

    @Test
    void addBlock() {
        courseService.addBlockInToCourse(COURSE.getId(), CLASS_BLOCK);
    }

    @Test
    void addPerson() {
        courseService.addPersonInToCourse(COURSE.getId(), PERSON);
    }

    @Test
    void editCourse() {
        courseService.editCourse(COURSE.getId(), COURSE);
    }
}