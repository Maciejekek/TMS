package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
todo dodawanie/usuwanie/edytowanie
 */
@RestController
@RequestMapping(value = "/persons", produces = {MediaType.APPLICATION_JSON_VALUE})

public class PersonController {

    //private final PersonService personService;

    private List<Person> personList;

    public PersonController() {
        this.personList = new ArrayList<>();
        personList.add(new Person(1L, "person1", "password1", "admin", "Halina", "Kowalska", true));
        personList.add(new Person(2L, "person2", "password2", "student", "Kamil", "Boczek", true));
        personList.add(new Person(3L, "person3", "password3", "student", "Andżelika", "Kiepska", true));
        personList.add(new Person(4L, "person4", "password4", "teacher", "Robert", "Rozrabiaka", true));
        personList.add(new Person(5L, "person5", "password5", "teacher", "Marta", "Szalona", true));
        personList.add(new Person(6L, "person6", "password6", "student", "Bożydar", "Cudowny", true));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> postAddPerson(@RequestBody Person person) {
        boolean addNewPerson = personList.add(person);
        if (addNewPerson) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Person> putEditPersonById(@RequestBody Person newPerson) {
        Optional<Person> optionalPerson = personList.stream()
                .filter(person -> person.getID() == newPerson.getID())
                .findFirst();

        if (optionalPerson.isPresent()) {
            personList.remove(optionalPerson.get());
            personList.add(newPerson);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable Long id) {
        Optional<Person> personOptional = personList.stream()
                .filter(person -> person.getID() == id)
                .findFirst();

        if (personOptional.isPresent()) {
            personList.remove(personOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/persons")
//    public String getPerson(Model model) {
//        List<Person> personList = personService.getPersonList();
//        model.addAttribute("person", personList);
//        return "";
//    }
//
//    @GetMapping("/addPerson")
//    public String getAddPerson() {
//        return "";
//    }
//
//    @PostMapping("/addPerson")
//    public RedirectView postAddPerson(@Valid Person person) {
//        personService.getAddPerson(person);
//        return new RedirectView("");
//    }

//    @GetMapping("/editPerson/{id}")
//    public String getEditPerson(@PathVariable Long id, Model model) {
//        Person personById = personService.getPersonById(id);
//        model.addAttribute("person", personById);
//        return "";
//    }
//
//    @PostMapping("/editPerson/{id}")
//    public RedirectView postEditPerson(@Valid Person person) {
//        personService.getEditPerson(person);
//        return new RedirectView("");
//    }

//    @PostMapping("/deletePerson/{id}")
//    public RedirectView deletePerson(@PathVariable Long id) {
//        personService.deletePersonById(id);
//        return new RedirectView("");
//    }


}
