package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
}
