package com.example.trainingmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany()
    private List<ClassBlock> classBlockList = new LinkedList<>();

    @ManyToMany(mappedBy = "courseList")
    @JsonIgnore
    private List<Person> personList = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Notification> notificationsList = new LinkedList<>();
}
