package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.ClassesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassesService {

    ClassesRepository classesRepository;

    public ClassesService(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }
}
