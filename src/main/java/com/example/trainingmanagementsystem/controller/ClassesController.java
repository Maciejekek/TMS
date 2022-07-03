package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.service.ClassesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/classes")
public class ClassesController {

    ClassesService classesService;

    @GetMapping
    public List<Classes> getAllClasses(){
        return classesService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Classes getClassesById(@PathVariable Long id) {
        return classesService.getClassesById(id);
    }

    @PostMapping
    public Classes addClasses(@RequestBody Classes classes) {
        return classesService.addClasses(classes);
    }

    @PatchMapping
    public ResponseEntity<Classes> editClasses(@RequestParam("classesId") Long id, @RequestBody Classes classes) {
        var editClasses = classesService.editClasses(id, classes);
        return ResponseEntity.ok(editClasses);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteClasses(@RequestParam("classesId") Long id, @RequestParam("blockId") Long blockId) {
        String response = classesService.delete(id, blockId);
        return switch (response) {
            case "SUCCESS" -> new ResponseEntity<>(HttpStatus.NO_CONTENT);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

}
