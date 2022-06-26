package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;

    @OneToMany
    private List<ClassBlock> classBlockList = new LinkedList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> personList = new LinkedList<>();

    @OneToMany
    private List<Notification> notificationsList = new LinkedList<>();
}
