package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.service.ClassBlockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ClassBlock getClassBlockById(@PathVariable("id") Long id) {
        return classBlockService.findById(id);
    }

    @PostMapping
    public ClassBlock createClassBlock(@RequestBody ClassBlock classBlock) {
        return classBlockService.createClassBlock(classBlock);
    }

    @PatchMapping
    public ResponseEntity<ClassBlock> editClassBlock(@RequestParam("classBlockId") Long id, @RequestBody ClassBlock classBlock) {
        return classBlockService.editClassBlock(id, classBlock);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteClassBlock(@RequestParam("classBlockId") Long id) {
        return classBlockService.deleteClassBlock(id);
    }

    @PutMapping
    public ResponseEntity<ClassBlock> addClassInToClassBlock(@RequestParam("classBlockId") Long id, @RequestParam("classesId") Long classesId){
        return classBlockService.addClassesInBlock(id, classesId);
    }
}
