package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.ClassBlockRepository;
import com.example.trainingmanagementsystem.repository.ClassesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ClassBlockService {

    ClassBlockRepository classBlockRepository;
    ClassesRepository classesRepository;

    public List<ClassBlock> findAll() {
        return classBlockRepository.findAll();
    }

    public ClassBlock addClassBlock(ClassBlock classBlock) {
        return classBlockRepository.save(classBlock);
    }

    public ClassBlock findById(Long id) {
        return classBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:" + id + " not exist"));
    }

    public ResponseEntity<ClassBlock> editClassBlock(Long id, ClassBlock classBlock) {
        var updateClassBlock = classBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:" + id + " not exist"));

        updateClassBlock.setName(classBlock.getName());

        classBlockRepository.save(updateClassBlock);

        return ResponseEntity.ok(updateClassBlock);
    }

    public ResponseEntity<HttpStatus> deleteClassBlock(Long id) {
        ClassBlock classBlock = classBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:" + id + "not exist"));

        classBlockRepository.delete(classBlock);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<ClassBlock> addClassesInBlock(Long id, Long classesId){
        ClassBlock classBlock = classBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:" + id + "not exist"));
        Classes classes = classesRepository
                .findById(classesId)
                .orElseThrow(() -> new ResourceNotFoundException("Class with id:" + id + "not exist"));

        classBlock.getClassesList().add(classes);
        classBlockRepository.save(classBlock);
        return ResponseEntity.ok(classBlock);
    }
}
