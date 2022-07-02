package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassBlockRepository extends JpaRepository<ClassBlock, Long> {
}
