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
    public List<Notification> getAllNotifications() {
        return notificationService.getAll();
    }

    @PostMapping("/notifications")
    public void createNotification(@RequestBody Notification notification,@RequestParam("courseId") Long courseId) {
        notificationService.save(notification, courseId);
    }

    @PutMapping("/notifications/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable("id") Long id, @RequestBody Notification notification) {
        var editNotification = notificationService.update(id, notification);
        return ResponseEntity.ok(editNotification);
    }

    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable("id") Long id) {
        String response = notificationService.delete(id);
        return switch (response) {
            case "SUCCESS" -> new ResponseEntity<>(HttpStatus.NO_CONTENT);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
