package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.ParticipantApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantApplicationService {
    public ParticipantApplicationService(ParticipantApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    ParticipantApplicationRepository applicationRepository;
}
