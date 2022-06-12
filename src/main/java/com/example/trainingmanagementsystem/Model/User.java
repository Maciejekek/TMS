package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    Long ID;

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
