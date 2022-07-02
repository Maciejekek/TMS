package com.example.trainingmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonCourseListResponse {
    List<PersonDTO> personList = new LinkedList<>();
}
