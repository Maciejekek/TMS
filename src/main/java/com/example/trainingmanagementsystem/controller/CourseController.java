package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    public CourseController(CourseService service) {
        this.service = service;
    }

    CourseService service;

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return service.addCourse(course);
    }

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

    @PutMapping("/course/addpersonblock?course={id}")
    public ResponseEntity<Course> addPerson(@PathVariable Long id, @RequestBody Person person){
        return service.addPersonInToCourse(id, person);
    }

    @PutMapping("course/edit?course={id}")
    public ResponseEntity<Course> editCourse(@PathVariable Long id, @RequestBody Course course){
        return service.editCourse(id, course);
    }

    @DeleteMapping("/course/deletepersonfrom")
    public ResponseEntity<HttpStatus> deletePersonFromCourse(@RequestParam("course") Long id, @RequestParam("personId") Long personId){
        return service.deletePersonFromCourse(id, personId);
    }

    @DeleteMapping("/course/deleteblockfrom")
    public ResponseEntity<HttpStatus> deleteBlockFromCourse(@RequestParam("course") Long id, @RequestParam("blockId") Long blockId){
        return service.deleteBlockFromCourse(id, blockId);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id){
        return service.deleteCourse(id);
    }

}
