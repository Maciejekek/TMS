package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    Long ID;

    String login;

    String password;

    String type;

    String name;

    String lastName;

    Boolean isActive;

    List<Course> courseList;

    List<UserNotification> notifications;
}
