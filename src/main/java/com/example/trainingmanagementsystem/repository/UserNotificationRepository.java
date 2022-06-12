package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
}
