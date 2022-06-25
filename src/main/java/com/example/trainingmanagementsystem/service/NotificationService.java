package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {


    public NotificationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    PersonRepository personRepository;

    public List<Notification> getAll(Long userId) {

        return personRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:" + userId + " not exist"))
                .getCourseList()
                .stream()
                .map(Course::getNotificationsList)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        /*
        Person person = personRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:" + userId + " not exist"));

        var courseList = person.getCourseList();

        List<List<Notification>> notificationList = new ArrayList<>();

        courseList.forEach(
                course -> notificationList.add(course.getNotificationsList())
        );

        var list = notificationList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return list;*/
    }


}
