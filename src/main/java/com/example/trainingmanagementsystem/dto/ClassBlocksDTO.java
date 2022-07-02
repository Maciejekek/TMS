package com.example.trainingmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassBlocksDTO {
    String name;

    List<ClassesDTO> classesList = new LinkedList<>();
}
