package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.PersonNotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonNotificationService {
    public PersonNotificationService(PersonNotificationRepository personNotificationRepository) {
        this.personNotificationRepository = personNotificationRepository;
    }

    PersonNotificationRepository personNotificationRepository;
}
