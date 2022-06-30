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
    public Classes getClassesById(@PathVariable Long id){
        return classesService.getClassesById(id);
    }

    @PostMapping
    public Classes addClasses(@RequestBody Classes classes){
        return classesService.addClasses(classes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Classes> editClasses(@PathVariable Long id, @RequestBody Classes classes){
        return classesService.editClasses(id, classes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClasses(@PathVariable Long id){
        return classesService.delete(id);
    }

}
