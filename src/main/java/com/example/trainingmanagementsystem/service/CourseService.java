package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.CourseRepository;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseService {

    CourseRepository courseRepository;
    PersonRepository personRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public List<Course> getCourseByPersonId(Long id){
        return personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:" + id + "not exist"))
                .getCourseList();
    }

    public ResponseEntity<Course> addBlockInToCourse(Long id, ClassBlock classBlock){
        Course updateCourse = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));
        updateCourse.getClassBlockList().add(classBlock);
        courseRepository.save(updateCourse);
        return ResponseEntity.ok(updateCourse);
    }

    public ResponseEntity<Course> addPersonInToCourse(Long id, Person person){
        Course updateCourse = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));
        updateCourse.getPersonList().add(person);
        courseRepository.save(updateCourse);
        return ResponseEntity.ok(updateCourse);
    }

    public ResponseEntity<HttpStatus> deleteCourse(Long id){
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));
        courseRepository.delete(course);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteBlockFromCourse(Long id, Long blockId){
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        var optionalClassBlock = course.getClassBlockList()
                .stream()
                .filter(classBlock -> classBlock.getId().equals(blockId))
                .findFirst();

        optionalClassBlock.ifPresent(tmp -> course.getClassBlockList().remove(tmp));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deletePersonFromCourse(Long id, Long personId){
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        var optionalPerson = course.getPersonList()
                .stream()
                .filter(person -> person.getId().equals(personId))
                .findFirst();

        optionalPerson.ifPresent(person -> course.getPersonList().remove(person));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public ResponseEntity<Course> editCourse(Long id, Course course) {
        Course updateCourse = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ id + "not exist"));

        updateCourse.setName(course.getName());

        courseRepository.save(updateCourse);

        return ResponseEntity.ok(updateCourse);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
