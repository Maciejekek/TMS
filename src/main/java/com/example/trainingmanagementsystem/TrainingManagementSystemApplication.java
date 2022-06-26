package com.example.trainingmanagementsystem;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.Model.Classes;
import com.example.trainingmanagementsystem.Model.Course;
import com.example.trainingmanagementsystem.Model.Person;
import com.example.trainingmanagementsystem.service.ClassBlockService;
import com.example.trainingmanagementsystem.service.ClassesService;
import com.example.trainingmanagementsystem.service.CourseService;
import com.example.trainingmanagementsystem.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Person person1 = new Person();
        person1.setLogin("Rybak");
        person1.setPassword("MiToRybka");
        person1.setType("user");
        person1.setName("Tomasz");
        person1.setLastName("J");
        person1.setIsActive(true);
        personService.getAddPerson(person1);

        Person person2 = new Person();
        person2.setLogin("Rybak2");
        person2.setPassword("MiToRybka3");
        person2.setType("user");
        person2.setName("Magda");
        person2.setLastName("Magda");
        person2.setIsActive(true);
        personService.getAddPerson(person2);

        Person person3 = new Person();
        person3.setLogin("Rybak4");
        person3.setPassword("MiToRybka5");
        person3.setType("user");
        person3.setName("Maciej");
        person3.setLastName("Maciejewicz");
        person3.setIsActive(true);
        personService.getAddPerson(person3);

        Person person4 = new Person();
        person4.setLogin("Rybak6");
        person4.setPassword("MiToRybka7");
        person4.setType("user");
        person4.setName("J");
        person4.setLastName("Tomasz");
        person4.setIsActive(true);
        personService.getAddPerson(person4);

        Classes classes1 = new Classes();
        classes1.setTopic("Typy danych");
        classes1.setDate(LocalDate.of(2022,6,25));
        classesService.getAddClass(classes1);

        Classes classes2 = new Classes();
        classes2.setTopic("Metody");
        classes2.setDate(LocalDate.of(2022,6,26));
        classesService.getAddClass(classes2);

        ClassBlock classBlock1 = new ClassBlock();
        classBlock1.setName("Podstawy");
        classBlockService.getAddClassBlock(classBlock1);

        ClassBlock classBlock2 = new ClassBlock();
        classBlock2.setName("Zawansowane");
        classBlockService.getAddClassBlock(classBlock2);

        classBlockService.addClassesInBlock(1L, classes1);
        classBlockService.addClassesInBlock(1L, classes2);

        Course course1 = new Course();
        course1.setName("Java");
        courseService.addCourse(course1);
        courseService.addPersonInToCourse(1L, person1);
        courseService.addPersonInToCourse(1L, person2);
        courseService.addPersonInToCourse(1L, person3);
        courseService.addPersonInToCourse(1L, person4);
        courseService.addBlockInToCourse(1L, classBlock1);
        courseService.addBlockInToCourse(1L, classBlock2);

    }
}
