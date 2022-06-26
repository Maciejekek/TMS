package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {

    PersonRepository personRepository;
    public ResponseEntity<Person> findById(Long id){
        Person person = personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(person);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public ResponseEntity<Person> editPerson(Long id, Person person){
        Person updatePerson = personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        updatePerson.setLogin(person.getLogin());
        updatePerson.setPassword(person.getPassword());
        updatePerson.setType(person.getType());
        updatePerson.setName(person.getName());
        updatePerson.setLastName(person.getLastName());
        updatePerson.setIsActive(person.getIsActive());

        personRepository.save(updatePerson);

        return ResponseEntity.ok(updatePerson);
    }
    public List<Person> findAll(){
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
