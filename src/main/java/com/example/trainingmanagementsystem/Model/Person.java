package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String login;

    String password;

    String type;

    String name;

    String lastName;

    Boolean isActive;

//    List<Course> courseList;
//
//    List<UserNotification> notifications;
}
