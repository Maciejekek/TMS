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
        var person = personService.findById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<PersonAccountData> getPersonAccountDataById(@PathVariable Long id) {
        var data =  personService.findPersonDataById(id);
        return ResponseEntity.ok(data);
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
        var editPerson = personService.editPerson(id, person);
        return ResponseEntity.ok(editPerson);
    }

    @PatchMapping("/account/{id}")
    public ResponseEntity<PersonAccountData> editPersonAccountData(@PathVariable Long id, @RequestBody PersonAccountData personAccountData) {
        var editData = personService.editPersonAccountData(id, personAccountData);
        return ResponseEntity.ok(editData);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable Long accountId) {
        String response = personService.deletePerson(accountId);
        return switch (response) {
            case "SUCCESS" -> new ResponseEntity<>(HttpStatus.NO_CONTENT);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

}
