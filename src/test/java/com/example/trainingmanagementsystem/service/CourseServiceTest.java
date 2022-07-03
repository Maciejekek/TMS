package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.*;
import com.example.trainingmanagementsystem.dto.ClassBlocksDTO;
import com.example.trainingmanagementsystem.dto.CourseResponse;
import com.example.trainingmanagementsystem.repository.CourseRepository;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CourseServiceTest {

    @MockBean
    private CourseRepository courseRepository;

    @Mock
    private static List<Course> courseList = new ArrayList<>();

    @InjectMocks
    private CourseService courseService;

    @Mock
    private static List<ClassBlock> classBlockList = new ArrayList<>();

    @Mock
    private static List<Person> personList = new ArrayList<>();
    @Mock
    private static List<PersonNotification> personNotificationList = new ArrayList<>();
    private static final Person PERSON = new Person(1l, "name", "lastName", personNotificationList, courseList);

    @Mock
    private static List<Notification> notificationList = new ArrayList<>();
    private static final Course COURSE = new Course(1l, "name", classBlockList, personList, notificationList);
    @MockBean
    private PersonRepository personRepository;

    @Mock
    private static List<ClassBlocksDTO> classBlocksDTOS = new ArrayList<>();

    @Mock
    private ModelMapper modelMapper;

    @Test
    void convertClassBlock() {
    }

    @Test
    void convertClasses() {
    }

    @Test
    @DisplayName("Should get course By Id")
    void shouldGetCourseById() {
        Mockito.when(courseRepository.findById(anyLong())).thenReturn(Optional.of(COURSE));

        CourseResponse result = courseService.getCourseById(COURSE.getId());

        assertThat(result).isNull();
        assertThat(result).isEqualTo(COURSE.getClassBlockList());

    }

    @Test
    @DisplayName("Should get Course by Person")
    void getCourseByPerson() {
        Mockito.when(courseRepository.findById(anyLong())).thenReturn(Optional.of(COURSE));

        List<Course> result = courseService.getCourseByPerson(PERSON.getId());

        assertThat(result).isEqualTo(courseList);


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