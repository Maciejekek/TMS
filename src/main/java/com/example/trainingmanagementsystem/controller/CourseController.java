package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.dto.CoursePersonListRequest;
import com.example.trainingmanagementsystem.dto.CoursePersonListResponse;
import com.example.trainingmanagementsystem.dto.CourseRequest;
import com.example.trainingmanagementsystem.dto.CourseResponse;
import com.example.trainingmanagementsystem.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CourseController {

    CourseService service;

    @PostMapping
    public Course addCourse(@RequestBody CourseRequest courseRequest){
        return service.addCourse(courseRequest);
    }

    @GetMapping("/course")
    public List<CourseResponse> getAllCourse(){
        return service.findAllCourses();
    }

    @GetMapping("/course/")
    public List<Course> getCourseByPerson(@RequestParam("personId") Long id){
        return service.getCourseByPerson(id);
    }

    @GetMapping("/course/{courseId}")
    public Course getCourseById(@PathVariable Long courseId){
        return service.getCourseById(courseId);
    }

    @GetMapping("/course/personList")
    public CoursePersonListResponse getCoursePersonList(@RequestBody CoursePersonListRequest coursePersonListRequest){
        return service.getCoursePersonList(coursePersonListRequest);
    }

    @PutMapping("/course/")
    public ResponseEntity<Course> addBlockInToCourse(@RequestParam("courseId") Long courseId, @RequestParam("blockId") Long blockId){
        return service.addBlockInToCourse(courseId, blockId);
    }

    @PutMapping("/course/addperson")
    public ResponseEntity<Course> addPersonInToCourse(@RequestParam("courseId") Long id, @RequestParam("personId") Long personId){
        return service.addPersonInToCourse(id, personId);
    }

    @PatchMapping("/course/edit")
    public ResponseEntity<Course> editCourse(@RequestParam("courseId") Long id, @RequestBody Course course){
        return service.editCourse(id, course);
    }

    @DeleteMapping("/course/deleteperson")
    public ResponseEntity<HttpStatus> deletePersonFromCourse(@RequestParam("course") Long id, @RequestParam("personId") Long personId){
        return service.deletePersonFromCourse(id, personId);
    }

    @DeleteMapping("/course/deleteblock")
    public ResponseEntity<HttpStatus> deleteBlockFromCourse(@RequestParam("course") Long id, @RequestParam("blockId") Long blockId){
        return service.deleteBlockFromCourse(id, blockId);
    }

    @DeleteMapping("/course")
    public ResponseEntity<HttpStatus> deleteCourse(@RequestParam("course")Long id){
        return service.deleteCourse(id);
    }

}
