package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.service.ClassBlockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/classBlocks")
public class ClassBlockController {

    private final ClassBlockService classBlockService;

    @GetMapping
    public List<ClassBlock> getAllClassBlocks() {
        return classBlockService.findAll();
    }

    @GetMapping("{id}")
    public ClassBlock getClassBlockById(@PathVariable Long id) {
        return classBlockService.findById(id);
    }

    @PostMapping
    public ClassBlock addClassBlock(@RequestBody ClassBlock classBlock) {
        return classBlockService.addClassBlock(classBlock);
    }

    @PatchMapping("{id}")
    public ResponseEntity<ClassBlock> patchClassBlock(@PathVariable Long id, @RequestBody ClassBlock classBlock) {
        return classBlockService.editClassBlock(id, classBlock);
    }

    @DeleteMapping("{id}")
    public void deleteClassBlock(@PathVariable Long id) {
        classBlockService.deleteClassBlock(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClassBlock> addClassInToClassBlock(@PathVariable Long id, @RequestBody Classes classes){
        return classBlockService.addClassesInBlock(id, classes);
    }
}