package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.service.NotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    NotificationService notificationService;

    @GetMapping("/notifications/{id}")
    public List<Notification> getNotifications(@RequestBody Long id){
        return notificationService.getAll(id);
    }

}
