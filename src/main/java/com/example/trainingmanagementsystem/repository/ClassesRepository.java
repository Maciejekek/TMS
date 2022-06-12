package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
}
