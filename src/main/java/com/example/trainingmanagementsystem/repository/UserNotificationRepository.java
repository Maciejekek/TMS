package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<User, Long> {
}
