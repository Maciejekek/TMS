package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClassBlockServiceTest {

    private static final ClassBlock CLASS_BLOCK = new ClassBlock(1l, "name");

    @Mock
    private ClassBlockService classBlockService;

    @Test
    void findAll() {
        classBlockService.findAll();
    }

    @Test
    void getAddClassBlock() {
        classBlockService.getAddClassBlock(CLASS_BLOCK);
    }

    @Test
    void getEditClassBlock() {
        classBlockService.getEditClassBlock(CLASS_BLOCK.getId(), CLASS_BLOCK);

    }

    @Test
    void findById() {
        classBlockService.findById(CLASS_BLOCK.getId());
    }

    @Test
    void deleteClassBlock() {
        classBlockService.deleteClassBlock(CLASS_BLOCK.getId());
    }
}