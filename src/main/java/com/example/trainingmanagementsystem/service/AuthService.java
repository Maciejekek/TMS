package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.Model.PersonAccountData;
import com.example.trainingmanagementsystem.dto.RegisterRequest;
import com.example.trainingmanagementsystem.dto.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    PersonService personService;

    public void signup(RegisterRequest registerRequest) {
        Person person = new Person();
        person.setName(registerRequest.getName());
        person.setLastName(registerRequest.getLastName());
        PersonAccountData accountData = new PersonAccountData();
        accountData.setLogin(registerRequest.getLogin());
        accountData.setPassword(registerRequest.getPassword());
        accountData.setEmail(registerRequest.getEmail());
        accountData.setPerson(person);
        accountData.setAuthToken(generateVerificationToken());
        personService.savePerson(person);
        personService.savePersonAccountData(accountData);
    }

    public void login(LoginRequest loginRequest){
        var cos = personService.findAllPersonsAccountData()
                .stream()
                .filter(n -> n.getLogin()
                        .equals(loginRequest.getLogin()) && n.getPassword()
                        .equals(loginRequest.getPassword()))
                .findFirst();
    }

    private String generateVerificationToken(){
        return UUID.randomUUID().toString();
    }
}
