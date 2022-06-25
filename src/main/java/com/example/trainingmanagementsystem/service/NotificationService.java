package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.NotificationRepository;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@AllArgsConstructor
public class NotificationService {


    PersonRepository personRepository;
  
    NotificationRepository notificationRepository;

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


    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public ResponseEntity<Notification> getById(Long id) {
        return ResponseEntity.ok(notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id:" + id + "not exist")));
    }

    public ResponseEntity<Notification> update(Long id, Notification notification) {
        Notification updateNotification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id:" + id + "not exist"));

        updateNotification.setDate(notification.getDate());
        updateNotification.setClassName(notification.getClassName());
        updateNotification.setDescription(notification.getDescription());

        notificationRepository.save(updateNotification);

        return ResponseEntity.ok(updateNotification);
    }

    public ResponseEntity<HttpStatus> delete(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id:" + id + "not exist"));

        notificationRepository.delete(notification);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
