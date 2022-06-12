package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
