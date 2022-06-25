package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo dodawanie usuwanie edycja kursu(admin)

//todo wyswietla listę blokow danego course

//todo dodawanie/usuwanie/edytowanie listy course

@RestController
public class CourseController {

    public CourseController(CourseService service) {
        this.service = service;
    }

    CourseService service;

    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return service.findAll();
    }

    @GetMapping("/course/person={id}")
    public List<Course> getCourseByPersonId(@RequestBody Long id){
        return service.getCourseByPersonId(id);
    }

    @PutMapping("/course/addclassblock?course={id}")
    public ResponseEntity<Course> addBlock(@PathVariable Long id, @RequestBody ClassBlock classBlock){
        return service.addBlockInToCourse(id, classBlock);
    }



}
