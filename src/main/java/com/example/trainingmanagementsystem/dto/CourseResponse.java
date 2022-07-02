package com.example.trainingmanagementsystem.dto;

import com.example.trainingmanagementsystem.Model.ClassBlock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    String name;

    List<ClassBlocksDTO> classBlocksList = new LinkedList<>();
}
