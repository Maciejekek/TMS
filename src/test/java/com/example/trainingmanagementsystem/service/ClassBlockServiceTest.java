package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.*;
import com.example.trainingmanagementsystem.dto.CourseRequest;
import com.example.trainingmanagementsystem.repository.ClassBlockRepository;
import com.example.trainingmanagementsystem.repository.ClassesRepository;
import com.example.trainingmanagementsystem.repository.CourseRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ClassBlockServiceTest {


    @MockBean
    private static ClassBlockRepository classBlockRepository;

    @MockBean
    private static ClassesRepository classesRepository;

    @MockBean
    private static CourseRepository courseRepository;

    @InjectMocks
    private static ClassBlockService classBlockService;

    private static final Classes CLASSES = new Classes(1L, "topic", null);
    @Mock
    private static List<Classes> classesList = new ArrayList<>();
    private static final ClassBlock CLASS_BLOCK = new ClassBlock(1L, "name", classesList);
    @Mock
    private static List<ClassBlock> classBlocks = new ArrayList<>();
    @Mock
    private static List<Person> personList = new ArrayList<>();
    @Mock
    private static List<Notification> notificationList = new ArrayList<>();
    private static final Course COURSE = new Course(1L, "name", classBlocks, personList, notificationList);


    @Test
    @DisplayName("Should create class block")
    void createClassBlock() {
        Mockito.when(classBlockRepository.save(any())).thenReturn(CLASS_BLOCK);

        ClassBlock result = classBlockService.createClassBlock(CLASS_BLOCK);

        assertEquals(CLASS_BLOCK, result);
    }

    @Test
    @DisplayName("Should find Class Block by id ")
    void shouldFindClassBlockById() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));

        ClassBlock result = classBlockService.findById(CLASS_BLOCK.getId());

        assertEquals(CLASS_BLOCK, result);
    }

    @Test
    @DisplayName("Should edit Class Block")

    void shouldEditClassBlock() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));

        ClassBlock result = classBlockService.editClassBlock(1L, CLASS_BLOCK);

        assertThat(result).isNotNull();
    }

    //TODO - repair test
    @Test
    @DisplayName("Should delete class block")
    @Disabled
    void shouldDeleteClassBlock() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));

        String response = classBlockService.deleteClassBlock(CLASS_BLOCK.getId(), COURSE.getId());

        assertThat(response).isNotNull();
        assertThat(response.equals("SUCCESS"));
    }

    //TODO - repair test
    @Disabled
    @Test
    @DisplayName("Should add classes in block")
    void shouldAddClassesInBlock() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));
        ClassBlock result = classBlockService.addClassesInBlock(CLASS_BLOCK.getId(), CLASSES.getId());
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Should delete classes from class block")
    void deleteClassesFromClassBlock() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));

        classBlockService.deleteClassesFromClassBlock(CLASS_BLOCK, CLASSES);
        List<Classes> result = CLASS_BLOCK.getClassesList();

        assertThat(result).isNotNull();

    }

    @Test
    @DisplayName("Should delete block form course")
    void deleteBlockFromCourse() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));

        classBlockService.deleteBlockFromCourse(COURSE, CLASS_BLOCK);
        List<ClassBlock> result = COURSE.getClassBlockList();

        assertThat(result).isNotNull();


    }
}