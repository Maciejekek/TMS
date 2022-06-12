package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.ClassBlockRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassBlockService {

    public ClassBlockService(ClassBlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    ClassBlockRepository blockRepository;
}
