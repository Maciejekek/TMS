package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany
    private List<PersonNotification> notificationList = new LinkedList<>();

    @ManyToMany
    @JoinTable(
            name = "person_courses",
            joinColumns = @JoinColumn(name = "personList_id"),
            inverseJoinColumns = @JoinColumn(name = "courseList_id")
    )
    List<Course> courseList = new LinkedList<>();
}
