package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOTIFICATION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date date;

    @Column(name = "CLASS_NAME")
    private String className;

    @Column(name = "DESCRIPTION")
    private String description;

}
