package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.Model.PersonAccountData;
import com.example.trainingmanagementsystem.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    PersonService personService;

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.findAllPersons();
    }

    @GetMapping("/accounts")
    public List<PersonAccountData> getAllPersonAccountData() {
        return personService.findAllPersonsAccountData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<PersonAccountData> getPersonAccountDataById(@PathVariable Long id) {
        return personService.findPersonDataById(id);
    }

    @PostMapping("/account")
    public PersonAccountData createPersonAccountData(@RequestBody PersonAccountData personAccountData) {
        return personService.savePersonAccountData(personAccountData);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Person> editPerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.editPerson(id, person);
    }

    @PatchMapping("/account/{id}")
    public ResponseEntity<PersonAccountData> editPersonAccountData(@PathVariable Long id, @RequestBody PersonAccountData personAccountData) {
        return personService.editPersonAccountData(id, personAccountData);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable Long accountId) {
        return personService.deletePerson(accountId);
    }

}
