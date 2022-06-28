package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.PersonAccountData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonAccountDataRepository extends JpaRepository<PersonAccountData, Long> {
}
