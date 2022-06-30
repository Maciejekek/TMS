package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class NotificationController {

    NotificationService notificationService;

    @GetMapping("/notifications")
    public List<Notification> getNotifications(@RequestBody Long id) {
        return notificationService.getAll();
    }

    @PostMapping("/notifications")
    public Notification createNotification(@RequestBody Notification notification,@RequestParam("courseId") Long courseId) {
        return notificationService.save(notification, courseId);
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
