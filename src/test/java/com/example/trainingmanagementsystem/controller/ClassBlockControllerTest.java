package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.service.ClassBlockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClassBlockControllerTest {

    private static final ClassBlock CLASS_BLOCK = new ClassBlock(1L, "name");

    @Mock
    private ClassBlockService classBlockService;


    @Test
    void getAllClassBlocks() {
        classBlockService.findAll();
    }

    @Test
    void getClassBlockById() {
        classBlockService.findById(CLASS_BLOCK.getId());
    }

    @Test
    void postAddClassBlock() {
        classBlockService.getAddClassBlock(CLASS_BLOCK);
    }

    @Test
    void patchClassBlock() {
        classBlockService.getEditClassBlock(CLASS_BLOCK.getId(), CLASS_BLOCK);
    }

    @Test
    void deleteClassBlock() {
        classBlockService.deleteClassBlock(CLASS_BLOCK.getId());
    }
}