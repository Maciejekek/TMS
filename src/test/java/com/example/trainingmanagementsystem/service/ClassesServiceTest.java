package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Classes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class ClassesServiceTest {

    private static final Classes CLASSES = new Classes(1l, "topic", new Date());

    @Mock
    private ClassesService classesService;

    @Test
    void findAll() {
        classesService.findAll();
    }

    @Test
    void getAddClass() {
        classesService.getAddClass(CLASSES);
    }

    @Test
    void getEditClass() {
        classesService.getEditClass(CLASSES);
    }

    @Test
    void getClassById() {
        classesService.getClassById(CLASSES.getId());
    }

    @Test
    void deleteClassById() {
        classesService.deleteClassById(CLASSES.getId());
    }
}