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

@AllArgsConstructor
@Service
public class ClassesService {

    ClassesRepository classesRepository;
    ClassBlockRepository blockRepository;

    public List<Classes> getAllClasses() {
        return classesRepository.findAll();
    }

    public Classes getClassesById(Long id) {
        return classesRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classes not exist with id: " + id));
    }

    public Classes addClasses(Classes classes) {
        return classesRepository.save(classes);
    }

    public ResponseEntity<Classes> editClasses(Long id, Classes classes) {
        Classes updateClasses = classesRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classes not exist with id: " + id));

        updateClasses.setTopic(classes.getTopic());
        updateClasses.setDate(classes.getDate());

        classesRepository.save(updateClasses);

        return ResponseEntity.ok(updateClasses);
    }

    public ResponseEntity<HttpStatus> delete(Long id, Long blockId) {
        Classes deleteClasses = classesRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classes not exist with id: " + id));

        ClassBlock classBlock = blockRepository
                .findById(blockId)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block not exist with id: " + blockId));

        classBlock.getClassesList().remove(deleteClasses);
        blockRepository.save(classBlock);

        classesRepository.delete(deleteClasses);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
