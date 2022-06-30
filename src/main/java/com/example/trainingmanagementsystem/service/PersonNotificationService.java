package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.PersonNotification;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.PersonNotificationRepository;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class PersonNotificationService {

    PersonRepository personRepository;
    PersonNotificationRepository repository;

    public List<PersonNotification> getAllNotifications(Long id) {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + id))
                .getNotificationList()
                .stream()
                .sorted(Comparator.comparing(PersonNotification::getIsRead,Comparator.reverseOrder()))
                .toList();
    }

    public List<PersonNotification> getAllReadNotifications(Long id) {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + id))
                .getNotificationList()
                .stream()
                .filter(n -> n.getIsRead().equals(true))
                .toList();
    }

    public List<PersonNotification> getAllNotReadNotifications(Long id) {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + id))
                .getNotificationList()
                .stream()
                .filter(n -> n.getIsRead().equals(false))
                .toList();
    }

    public void setToRead(List<PersonNotification> notificationList){
        notificationList.forEach(n -> n.setIsRead(true));
        notificationList.forEach(n -> repository.save(n));
    }
}
