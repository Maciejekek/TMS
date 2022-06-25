package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    private static final Person PERSON = new Person(null, 1l, "login", "password", "type", "name", "lastName", true);

    @Mock
    private PersonService personService;

    @Test
    void getPersonList() {
        personService.getPersonList();

    }

    @Test
    void getAddPerson() {
        personService.getAddPerson(PERSON);
    }

    @Test
    void getEditPerson() {
        personService.getEditPerson(PERSON);
    }

    @Test
    void getPersonById() {
        personService.getPersonById(PERSON.getId());
    }

    @Test
    void deletePersonById() {
        personService.deletePersonById(PERSON.getId());
    }
}