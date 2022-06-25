package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class NotificationControllerTest {

    private static final Notification NOTIFICATION = new Notification(1L, new Date(), "className", "des");

    @Mock
    private NotificationService notificationService;

    @Test
    void getNotifications() {
        notificationService.getAll(NOTIFICATION.getId());
    }
}