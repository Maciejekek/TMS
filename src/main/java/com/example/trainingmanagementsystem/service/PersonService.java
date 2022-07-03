package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.Model.PersonAccountData;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.PersonAccountDataRepository;
import com.example.trainingmanagementsystem.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {

    PersonAccountDataRepository dataRepository;
    PersonRepository personRepository;

    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }

    public List<PersonAccountData> findAllPersonsAccountData(){
        return dataRepository.findAll();
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public PersonAccountData savePersonAccountData(PersonAccountData personAccountData){
        return dataRepository.save(personAccountData);
    }

    public Person findById(Long id){
        return personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + id));
    }

    public PersonAccountData findPersonDataById(Long id) {
        return dataRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + id));
    }

    public PersonAccountData editPersonAccountData(Long id, PersonAccountData personAccountData){
        PersonAccountData dataUpdate = dataRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + id));
        dataUpdate.setLogin(personAccountData.getLogin());
        dataUpdate.setPassword(personAccountData.getPassword());
        dataUpdate.setType(personAccountData.getType());
        dataUpdate.setIsActive(personAccountData.getIsActive());
        dataUpdate.setEmail(personAccountData.getEmail());
        dataRepository.save(dataUpdate);
        return dataUpdate;
    }

    public Person editPerson(Long id, Person person){
        Person updatePerson = personRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + id));
        updatePerson.setName(person.getName());
        updatePerson.setLastName(person.getLastName());
        personRepository.save(updatePerson);
        return updatePerson;
    }

    public String deletePerson(Long accountId) {
        var accountData = dataRepository
                .findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id:" + accountId));
        var person = accountData.getPerson();
        person.getCourseList().clear();
        person.getNotificationList().clear();
        personRepository.save(person);
        dataRepository.delete(accountData);
        personRepository.delete(person);
        return "SUCCESS";
    }
}
