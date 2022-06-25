package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.ClassBlockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassBlockService {


    ClassBlockRepository classBlockRepository;

    public List<ClassBlock> findAll() {
        return classBlockRepository.findAll();
    }

    public ClassBlock getAddClassBlock(@RequestBody ClassBlock classBlock) {
        return classBlockRepository.save(classBlock);
    }

    public ClassBlock getEditClassBlock(@PathVariable Long id, @RequestBody ClassBlock classBlock) {
        classBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:" + id + " not exist"));

        return classBlockRepository.save(classBlock);

    }

    public ClassBlock findById(Long id) {
        return classBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:" + id + " not exist"));
    }

    public void deleteClassBlock(@PathVariable Long id) {
        ClassBlock classBlock = classBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class Block with id:" + id + "not exist"));

        classBlockRepository.delete(classBlock);

    }
}
