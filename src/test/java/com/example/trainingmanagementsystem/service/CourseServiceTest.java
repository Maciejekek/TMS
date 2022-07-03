package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.dto.ClassBlocksDTO;
import com.example.trainingmanagementsystem.dto.CourseResponse;
import com.example.trainingmanagementsystem.repository.CourseRepository;
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

    @InjectMocks
    private CourseService courseService;

    @Mock
    private static List<ClassBlock> classBlockList = new ArrayList<>();

    @Mock
    private static List<Person> personList = new ArrayList<>();

    @Mock
    private static List<Notification> notificationList = new ArrayList<>();
    private static final Course COURSE = new Course(1l, "name", classBlockList, personList, notificationList);
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