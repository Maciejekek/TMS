package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Notification;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NotificationService {

    NotificationRepository notificationRepository;
    CourseService courseService;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification save(Notification notification, Long id) {
        notificationRepository.save(notification);
        courseService.addNotification(notification, id);
        return notification;
    }

    public Notification getById(Long id){
        return notificationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id:" + id + "not exist"));
    }

    public Notification update(Long id, Notification notification) {
       Notification updateNotification = notificationRepository
               .findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Notification with id:" + id + "not exist"));
       updateNotification.setDate(notification.getDate());
       updateNotification.setClassName(notification.getClassName());
       updateNotification.setDescription(notification.getDescription());
       notificationRepository.save(updateNotification);
       return updateNotification;
    }

    public String delete(Long id){
        Notification notification = notificationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id:" + id + "not exist"));
        notificationRepository.delete(notification);
        return "SUCCESS";
    }
}
