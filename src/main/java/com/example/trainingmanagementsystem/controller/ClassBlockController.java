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
        var editClassBlock = classBlockService.editClassBlock(id, classBlock);
        return ResponseEntity.ok(editClassBlock);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteClassBlock(@RequestParam("classBlockId") Long id,@RequestParam("courseId")Long courseId) {
        String response = classBlockService.deleteClassBlock(id, courseId);
        return switch (response) {
            case "SUCCESS" -> new ResponseEntity<>(HttpStatus.NO_CONTENT);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };

    }

    @PutMapping
    public ResponseEntity<ClassBlock> addClassInToClassBlock(@RequestParam("classBlockId") Long id, @RequestParam("classesId") Long classesId){
        var classBlock = classBlockService.addClassesInBlock(id, classesId);
        return ResponseEntity.ok(classBlock);
    }
}
