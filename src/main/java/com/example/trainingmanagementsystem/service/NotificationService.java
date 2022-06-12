package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    NotificationRepository notificationRepository;
}
