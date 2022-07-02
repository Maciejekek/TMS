package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.PersonNotification;
import com.example.trainingmanagementsystem.service.PersonNotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PersonNotificationController {

    PersonNotificationService service;

    @GetMapping("/notification/user={id}")
    public List<PersonNotification> getAllNotifications(@PathVariable Long id){
        List<PersonNotification> list = service.getAllNotifications(id);
        service.setToRead(list);
        return list;
    }

    @GetMapping("/notification/read/user={id}")
    public List<PersonNotification> getAllReadNotifications(@PathVariable Long id){
        return service.getAllReadNotifications(id);
    }

    @GetMapping("/notification/not-read/user={id}")
    public List<PersonNotification> getAllNotReadNotifications(@PathVariable Long id){
        List<PersonNotification> list = service.getAllNotReadNotifications(id);
        service.setToRead(list);
        return list;
    }
}
