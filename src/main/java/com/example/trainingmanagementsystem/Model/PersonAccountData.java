package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonAccountData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;

    @Column(name = "LOGIN")
    @NotBlank
    private String login;

    @Column(name = "PASSWORD")
    @NotBlank
    private String password;

    private String authToken;

    @Email
    @NotEmpty
    private String email;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
}
