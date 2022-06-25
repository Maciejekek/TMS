package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    private static final Course COURSE = new Course(1l, "name", null, null, null);
    private static final ClassBlock CLASS_BLOCK = new ClassBlock(1l, "name");
    private static final Person PERSON = new Person(null, 1l, "login", "password", "type", "name", "lastName", true);

    @Mock
    private CourseService courseService;

    @Test
    void findAll() {
        courseService.findAll();
    }

    @Test
    void getCourseById() {
        courseService.getCourseByPersonId(COURSE.getId());
    }

    @Test
    void addBlockInToCourse() {
        courseService.addBlockInToCourse(COURSE.getId(), CLASS_BLOCK);
    }

    @Test
    void addPersonInToCourse() {
        courseService.addPersonInToCourse(COURSE.getId(), PERSON);
    }

    @Test
    void deleteCourse() {
        courseService.deleteCourse(COURSE.getId());
    }

    @Test
    void deleteBlockFromCourse() {
        courseService.deleteBlockFromCourse(COURSE.getId(), CLASS_BLOCK.getId());
    }

    @Test
    void deletePersonFromCourse() {
        courseService.deletePersonFromCourse(COURSE.getId(), PERSON.getId());
    }
}