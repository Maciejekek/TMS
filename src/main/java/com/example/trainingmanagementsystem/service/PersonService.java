package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    public void getAddPerson(Person person) {
        personRepository.save(person);
    }

    public void getEditPerson(Person person) {
        personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }


}
