package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
