package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.PersonNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonNotificationRepository extends JpaRepository<PersonNotification, Long> {
}
