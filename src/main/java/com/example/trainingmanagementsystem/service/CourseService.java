package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseService {
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    CourseRepository courseRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        return ResponseEntity.ok(course);
    }

    public ResponseEntity<Course> addBlockInToCourse(@PathVariable Long id, @RequestBody ClassBlock classBlock){
        Course updateCourse = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        updateCourse.getClassBlockSet().add(classBlock);

        courseRepository.save(updateCourse);

        return ResponseEntity.ok(updateCourse);
    }

    public ResponseEntity<Course> addPersonInToCourse(@PathVariable Long id, @RequestBody Person person){
        Course updateCourse = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        updateCourse.getPersonSet().add(person);

        courseRepository.save(updateCourse);

        return ResponseEntity.ok(updateCourse);
    }

    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id){
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        courseRepository.delete(course);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteBlockFromCourse(@PathVariable Long id, @RequestBody Long blockId){
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        var cos = course.getClassBlockSet()
                .stream()
                .filter(classBlock -> classBlock.getId().equals(blockId))
                .findFirst();

        cos.ifPresent(tmp -> course.getClassBlockSet().remove(tmp));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deletePersonFromCourse(@PathVariable Long id, @RequestBody Long personId){
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        var cos = course.getPersonSet()
                .stream()
                .filter(person -> person.getId().equals(personId))
                .findFirst();

        cos.ifPresent(tmp -> course.getPersonSet().remove(tmp));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
