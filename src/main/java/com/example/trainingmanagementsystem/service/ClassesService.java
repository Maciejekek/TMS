package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.repository.ClassesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {

    ClassesRepository classesRepository;

    public ClassesService(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }


    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    public void getAddClass(Classes classes) {
        classesRepository.save(classes);
    }

    public void getEditClass(Classes classes) {
        classesRepository.save(classes);
    }

    public Classes getClassById(Long id) {
        return classesRepository.findById(id).orElse(null);
    }

    public void deleteClassById(Long id) {
        classesRepository.deleteById(id);
    }


}
