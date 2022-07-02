package com.example.trainingmanagementsystem.repository;

import com.example.trainingmanagementsystem.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
