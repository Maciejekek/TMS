package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Notification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    private static final Notification NOTIFICATION = new Notification(1l, new Date(), "className", "des");

    @Mock
    private NotificationService notificationService;

    @Test
    void getAll() {
        notificationService.getAll(NOTIFICATION.getId());
    }

    @Test
    void save() {
        notificationService.save(NOTIFICATION);
    }

    @Test
    void getById() {
        notificationService.getById(NOTIFICATION.getId());
    }

    @Test
    void update() {
        notificationService.update(NOTIFICATION.getId(), NOTIFICATION);
    }

    @Test
    void delete() {
        notificationService.delete(NOTIFICATION.getId());
    }
}