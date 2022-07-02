package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.*;
import com.example.trainingmanagementsystem.dto.*;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.ClassBlockRepository;
import com.example.trainingmanagementsystem.repository.CourseRepository;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CourseService {

    CourseRepository courseRepository;
    PersonRepository personRepository;
    ClassBlockRepository blockRepository;
    ClassBlockService blockService;
    ModelMapper modelMapper;

    public List<CourseResponse> findAllCourses(){
        return courseRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CourseResponse convertToDTO(Course course){
        List<ClassBlocksDTO> blocksDTO = course.getClassBlockList()
                .stream()
                .map(this::convertClassBlock)
                .collect(Collectors.toList());
        CourseResponse response = modelMapper.map(course, CourseResponse.class);
        response.setClassBlocksList(blocksDTO);
        return response;
    }
    public ClassBlocksDTO convertClassBlock(ClassBlock block){
        List<ClassesDTO> classesDTO = block.getClassesList()
                .stream()
                .map(this::convertClasses)
                .collect(Collectors.toList());
        ClassBlocksDTO blocksDTO = modelMapper.map(block, ClassBlocksDTO.class);
        blocksDTO.setClassesList(classesDTO);
        return blocksDTO;
    }
    public ClassesDTO convertClasses(Classes classes){
        return modelMapper.map(classes , ClassesDTO.class);
    }

    public CourseResponse getCourseById(Long courseId) {
        var course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));
        return convertToDTO(course);
    }

    public List<Course> getCourseByPerson(Long id){
        return personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id:" + id + "not exist"))
                .getCourseList();
    }

    public ResponseEntity<Course> addBlockInToCourse(Long courseId, Long blockId){
        Course updateCourse = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));
        ClassBlock classBlock = blockRepository
                .findById(blockId)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:"+ blockId + "not exist"));
        updateCourse.getClassBlockList().add(classBlock);
        courseRepository.save(updateCourse);
        return ResponseEntity.ok(updateCourse);
    }

    public ResponseEntity<Course> addPersonInToCourse(Long courseId, Long PersonId){
        Course updateCourse = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));
        Person person = personRepository
                .findById(PersonId)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id:"+ PersonId + "not exist"));

        updateCourse.getPersonList().add(person);
        person.getCourseList().add(updateCourse);
        courseRepository.save(updateCourse);
        personRepository.save(person);
        return ResponseEntity.ok(updateCourse);
    }

    public ResponseEntity<HttpStatus> deleteCourse(Long courseId){
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));

        course.getClassBlockList().forEach(classBlock -> blockService.deleteClassBlock(classBlock.getId(), courseId));
        course.getPersonList().forEach(n -> course.getPersonList().remove(n));
        //todo

        courseRepository.delete(course);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteBlockFromCourse(Long courseId, Long blockId){
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));

        var optionalClassBlock = course.getClassBlockList()
                .stream()
                .filter(classBlock -> classBlock.getId().equals(blockId))
                .findFirst();

        optionalClassBlock.ifPresent(classBlock -> course.getClassBlockList().remove(classBlock));

        courseRepository.save(course);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deletePersonFromCourse(Long courseId, Long personId){
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));

        var optionalPerson = course.getPersonList()
                .stream()
                .filter(person -> person.getId().equals(personId))
                .findFirst();

        optionalPerson.ifPresent(person -> course.getPersonList().remove(person));
        optionalPerson.ifPresent(person -> person.getCourseList().remove(course));
        optionalPerson.ifPresent(person -> personRepository.save(person));
        courseRepository.save(course);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public ResponseEntity<Course> editCourse(Long courseId, Course course) {
        Course updateCourse = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));

        updateCourse.setName(course.getName());

        courseRepository.save(updateCourse);

        return ResponseEntity.ok(updateCourse);
    }

    public Course addCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setName(courseRequest.getName());
        return courseRepository.save(course);
    }

    public void addNotification(Notification notification, Long courseId) {

        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id:"+ courseId + "not exist"));

        course.getNotificationsList().add(notification);

        PersonNotification personNotification = new PersonNotification();
        personNotification.setNotification(notification);
        personNotification.setIsRead(false);

        course.getPersonList().forEach(person -> person.getNotificationList().add(personNotification));

        courseRepository.save(course);
    }

    public CoursePersonListResponse getCoursePersonList(CoursePersonListRequest coursePersonListRequest) {
        var cos = courseRepository.findByName(coursePersonListRequest.getName()).getPersonList();
        List<PersonDTO> listPersonDTO = new LinkedList<>();
        for (Person person: cos) {
            PersonDTO personDTO = new PersonDTO(
                    person.getName(), person.getLastName()
            );
            listPersonDTO.add(personDTO);
        }
        return new CoursePersonListResponse(listPersonDTO);
    }
}
