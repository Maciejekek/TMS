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
        var course = service.addBlockInToCourse(courseId, blockId);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/course/addPerson")
    public ResponseEntity<Course> addPersonInToCourse(@RequestParam("courseId") Long id, @RequestParam("personId") Long personId) {
        var course = service.addPersonInToCourse(id, personId);
        return ResponseEntity.ok(course);
    }

    @PatchMapping("/course/edit")
    public ResponseEntity<Course> editCourse(@RequestParam("courseId") Long id, @RequestBody EditCourseName name) {
        var course = service.editCourse(id, name);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/course/deletePerson")
    public ResponseEntity<HttpStatus> deletePersonFromCourse(@RequestParam("courseId") Long id, @RequestParam("personId") Long personId) {
        String response = service.deletePersonFromCourse(id, personId);
        return switch (response) {
            case "SUCCESS" -> new ResponseEntity<>(HttpStatus.NO_CONTENT);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

    @DeleteMapping("/course/deleteBlock")
    public ResponseEntity<HttpStatus> deleteBlockFromCourse(@RequestParam("courseId") Long id, @RequestParam("blockId") Long blockId) {
        String response = service.deleteBlockFromCourse(id, blockId);
        return switch (response) {
            case "SUCCESS" -> new ResponseEntity<>(HttpStatus.NO_CONTENT);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

    @DeleteMapping("/course")
    public ResponseEntity<HttpStatus> deleteCourse(@RequestParam("courseId") Long id) {
        String response = service.deleteCourse(id);
        return switch (response) {
            case "SUCCESS" -> new ResponseEntity<>(HttpStatus.NO_CONTENT);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

    @GetMapping("/calendar")
    public CalendarResponse getPersonCalendar(@RequestParam("personId")Long personId){
        return service.getPersonCalendar(personId);
    }

}
