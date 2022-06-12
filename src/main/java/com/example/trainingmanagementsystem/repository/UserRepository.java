package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserNotification, Long> {
}
