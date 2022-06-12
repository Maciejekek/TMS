package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.AdditionalRelationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalRelationshipsRepository extends JpaRepository<AdditionalRelationships,Long> {
}
