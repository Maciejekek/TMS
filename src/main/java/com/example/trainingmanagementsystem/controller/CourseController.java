package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.dto.*;
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

    @PostMapping("/course")
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
    public CourseResponse getCourseById(@PathVariable Long courseId){
        return service.getCourseById(courseId);
    }

    @GetMapping("/course/personList")
    public CoursePersonListResponse getCoursePersonList(@RequestBody CoursePersonListRequest coursePersonListRequest){
        return service.getCoursePersonList(coursePersonListRequest);
    }

    @PutMapping("/course/")
    public ResponseEntity<Course> addBlockInToCourse(@RequestParam("courseId") Long courseId, @RequestParam("personId") Long blockId){
        return service.addBlockInToCourse(courseId, blockId);
    }

    @PostMapping("/course/addPerson")
    public ResponseEntity<Course> addPersonInToCourse(@RequestParam("courseId") Long id, @RequestParam("personId") Long personId) {
        return service.addPersonInToCourse(id, personId);
    }

    @PatchMapping("/course/edit")
    public ResponseEntity<Course> editCourse(@RequestParam("courseId") Long id, @RequestBody EditCourseName name) {
        return service.editCourse(id, name);
    }

    @DeleteMapping("/course/deletePerson")
    public ResponseEntity<HttpStatus> deletePersonFromCourse(@RequestParam("courseId") Long id, @RequestParam("personId") Long personId) {
        return service.deletePersonFromCourse(id, personId);
    }

    @DeleteMapping("/course/deleteBlock")
    public ResponseEntity<HttpStatus> deleteBlockFromCourse(@RequestParam("courseId") Long id, @RequestParam("blockId") Long blockId) {
        return service.deleteBlockFromCourse(id, blockId);
    }

    @DeleteMapping("/course")
    public ResponseEntity<HttpStatus> deleteCourse(@RequestParam("courseId") Long id) {
        return service.deleteCourse(id);
    }

    @GetMapping("/calendar")
    public CalendarResponse getPersonCalendar(@RequestParam("personId")Long personId){
        return service.getPersonCalendar(personId);
    }

}
