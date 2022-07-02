package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.dto.ClassBlocksDTO;
import com.example.trainingmanagementsystem.repository.ClassBlockRepository;
import com.example.trainingmanagementsystem.repository.ClassesRepository;
import com.example.trainingmanagementsystem.repository.CourseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ClassBlockServiceTest {

    private static final ClassBlock CLASS_BLOCK = new ClassBlock(1L, "name", null);

    private static final ClassBlocksDTO CLASS_BLOCKS_DTO = new ClassBlocksDTO("name", null);

    @MockBean
    private ClassBlockRepository classBlockRepository;

    @MockBean
    private ClassesRepository classesRepository;

    @MockBean
    private CourseRepository courseRepository;

    @InjectMocks
    private ClassBlockService classBlockService;

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

        ResponseEntity<ClassBlock> result = classBlockService.editClassBlock(1L, CLASS_BLOCK);


        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    //TODO - repair test
    @Test
    @DisplayName("Should delete class block")
    void shouldDeleteClassBlock() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));
        ClassBlock classBlock = new ClassBlock(1L, "name", null);
        Course course = new Course(1L, "name", null, null, null);
        ResponseEntity<HttpStatus> result = classBlockService.deleteClassBlock(classBlock.getId(), course.getId());

        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(result.getBody()).isNull();


    }

    //TODO - repair test
    @Test
    @DisplayName("Should add classes in block")
    void shouldAddClassesInBlock() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));
        Classes classes = new Classes(1L, "topic", null);
        ResponseEntity<ClassBlock> result = classBlockService.addClassesInBlock(1L, classes.getId());

        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    @DisplayName("Should delete classes from class block")
    void deleteClassesFromClassBlock() {
        Mockito.when(classBlockRepository.findById(anyLong())).thenReturn(Optional.of(CLASS_BLOCK));
        Classes classes = new Classes(1L, "topic", null);

        classBlockService.deleteClassesFromClassBlock(CLASS_BLOCK, classes);

    }

    @Test
    void deleteBlockFromCourse() {
    }
}