package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    NotificationService notificationService;

    @GetMapping("/notifications/{id}")
    public List<Notification> getNotifications(@RequestBody Long id) {
        return notificationService.getAll(id);
    }

    @PostMapping("/notifications")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @PutMapping("/notifications/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification){
        return notificationService.update(id, notification);
    }

    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable Long id){
        return notificationService.delete(id);
    }
}
