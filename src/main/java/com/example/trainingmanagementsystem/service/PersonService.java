package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
