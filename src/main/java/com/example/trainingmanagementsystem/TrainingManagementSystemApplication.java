package com.example.trainingmanagementsystem;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.Model.PersonAccountData;
import com.example.trainingmanagementsystem.dto.CourseRequest;
import com.example.trainingmanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.time.LocalDate;

@SpringBootApplication
public class TrainingManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TrainingManagementSystemApplication.class, args);
    }

    @Autowired
    PersonService personService;
    @Autowired
    CourseService courseService;
    @Autowired
    ClassBlockService classBlockService;
    @Autowired
    ClassesService classesService;

    @Autowired
    NotificationService notificationService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Person person1 = new Person();
        person1.setName("Tomasz");
        person1.setLastName("J");
        personService.savePerson(person1);
        PersonAccountData personAccountData1 = new PersonAccountData();
        personAccountData1.setLogin("Rybak");
        personAccountData1.setPassword("MiToRybka");
        personAccountData1.setType("user");
        personAccountData1.setIsActive(true);
        personAccountData1.setPerson(person1);
        personService.savePersonAccountData(personAccountData1);

        Person person2 = new Person();
        person2.setName("Magda");
        person2.setLastName("Magda");
        personService.savePerson(person2);
        PersonAccountData personAccountData2 = new PersonAccountData();
        personAccountData2.setLogin("Rybak2");
        personAccountData2.setPassword("MiToRybka3");
        personAccountData2.setType("user");
        personAccountData2.setIsActive(true);
        personAccountData2.setPerson(person2);
        personService.savePersonAccountData(personAccountData2);

        Person person3 = new Person();
        person3.setName("Maciej");
        person3.setLastName("Maciejewicz");
        personService.savePerson(person3);
        PersonAccountData personAccountData3 = new PersonAccountData();
        personAccountData3.setLogin("Rybak4");
        personAccountData3.setPassword("MiToRybka5");
        personAccountData3.setType("user");
        personAccountData3.setIsActive(true);
        personAccountData3.setPerson(person3);
        personService.savePersonAccountData(personAccountData3);

        Person person4 = new Person();
        person4.setName("J");
        person4.setLastName("Tomasz");
        personService.savePerson(person4);
        PersonAccountData personAccountData4 = new PersonAccountData();
        personAccountData4.setLogin("Rybak6");
        personAccountData4.setPassword("MiToRybka7");
        personAccountData4.setType("user");
        personAccountData4.setIsActive(true);
        personAccountData4.setPerson(person4);
        personService.savePersonAccountData(personAccountData4);

        Classes classes1 = new Classes();
        classes1.setTopic("Typy danych");
        classes1.setDate(LocalDate.of(2022,6,25));
        classesService.addClasses(classes1);

        Classes classes2 = new Classes();
        classes2.setTopic("Metody");
        classes2.setDate(LocalDate.of(2022,6,26));
        classesService.addClasses(classes2);


        ClassBlock classBlock1 = new ClassBlock();
        classBlock1.setName("Podstawy");
        classBlockService.createClassBlock(classBlock1);

        ClassBlock classBlock2 = new ClassBlock();
        classBlock2.setName("Zawansowane");
        classBlockService.createClassBlock(classBlock2);

        classBlockService.addClassesInBlock(1L, 1L);
        classBlockService.addClassesInBlock(1L, 2L);


        CourseRequest courseRequest = new CourseRequest("Java");
        courseService.addCourse(courseRequest);
        courseService.addPersonInToCourse(1L, 1L);
        courseService.addPersonInToCourse(1L, 2L);
        courseService.addPersonInToCourse(1L, 3L);
        courseService.addPersonInToCourse(1L, 4L);
        courseService.addBlockInToCourse(1L, 1L);
        courseService.addBlockInToCourse(1L, 2L);


    }
}
