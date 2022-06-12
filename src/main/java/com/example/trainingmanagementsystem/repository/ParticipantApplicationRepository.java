package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.ParticipantApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantApplicationRepository extends JpaRepository<ParticipantApplication, Long> {
}
