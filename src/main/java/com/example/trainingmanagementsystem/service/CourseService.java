package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    CourseRepository courseRepository;
}
