package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.AdditionalRelationshipsRepository;
import org.springframework.stereotype.Service;

@Service
public class AdditionalRelationshipsService {
    public AdditionalRelationshipsService(AdditionalRelationshipsRepository relationshipsRepository) {
        this.relationshipsRepository = relationshipsRepository;
    }

    AdditionalRelationshipsRepository relationshipsRepository;
}
