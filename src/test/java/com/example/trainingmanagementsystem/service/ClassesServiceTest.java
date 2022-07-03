package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.repository.ClassBlockRepository;
import com.example.trainingmanagementsystem.repository.ClassesRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ClassesServiceTest {

    private static final Classes CLASSES = new Classes(1l, "topic", LocalDate.now());
    @Mock
    private static List<Classes> classesList = new ArrayList<>();
    private static final ClassBlock CLASS_BLOCK = new ClassBlock(1l, "name", classesList);
    @MockBean
    private ClassesRepository classesRepository;
    @MockBean
    private ClassBlockRepository classBlockRepository;
    @InjectMocks
    private ClassesService classesService;

    @Test
    @DisplayName("Should get Classes By id ")
    void shouldGetClassesById() {
        Mockito.when(classesRepository.findById(anyLong())).thenReturn(Optional.of(CLASSES));

        Classes classesById = classesService.getClassesById(CLASSES.getId());

        assertThat(classesById).isEqualTo(CLASSES);

    }

    @Test
    @DisplayName("Should add classes")
    void shouldAddClasses() {
        Mockito.when(classesRepository.save(any())).thenReturn(CLASSES);

        Classes result = classesService.addClasses(CLASSES);

        assertThat(result).isEqualTo(CLASSES);

    }

//    @Test
//    @DisplayName("Should edit Classes")
//    void shouldEditClasses() {
//        Mockito.when(classesRepository.findById(anyLong())).thenReturn(Optional.of(CLASSES));
//
//        ResponseEntity<Classes> result = classesService.editClasses(1L, CLASSES);
//
//        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//
//    @Test
//    @DisplayName("Should delete Classes")
//    void shouldDeleteClasses() {
//        Mockito.when(classesRepository.findById(anyLong())).thenReturn(Optional.of(CLASSES));
//
//        ResponseEntity<HttpStatus> result = classesService.delete(CLASSES.getId(), CLASS_BLOCK.getId());
//
//        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
}