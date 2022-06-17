package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.Classes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/classes")
public class ClassesController {

    private List<Classes> classesList;

    public ClassesController(List<Classes> classesList) {
        this.classesList = classesList;
    }

    @GetMapping("/allClasses")
    public ResponseEntity<List<Classes>> getAllClasses() {
        return new ResponseEntity<>(classesList, HttpStatus.OK);
    }

    @PostMapping("/addClasses")
    public ResponseEntity postAddClasses(@RequestBody Classes classes) {
        boolean addNewClasses = classesList.add(classes);
        if (addNewClasses) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/editClasses/{id}")
    public ResponseEntity patchClasses(@PathVariable Long id, @RequestBody Classes newClasses) {
        Optional<Classes> classesOptional = classesList.stream()
                .filter(classes -> classes.getId() == newClasses.getId())
                .findFirst();

        if (classesOptional.isPresent()) {
            classesList.remove(classesOptional.get());
            classesList.add(newClasses);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteClasses/{id}")
    public ResponseEntity deleteClasses(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesList.stream()
                .filter(classes -> classes.getId() == id)
                .findFirst();

        if (classesOptional.isPresent()) {
            classesList.remove(classesOptional.get());
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/allClasses")
//    public String getPerson(Model model) {
//        List<Classes> classesList = classesService.getClassesList();
//        model.addAttribute("person", personList);
//        return "";
//    }
//
//    @GetMapping("/addClass")
//    public String getAddClass() {
//        return "";
//    }
//
//    @PostMapping("/addClass")
//    public RedirectView postAddClass(@Valid Classes Classes) {
//        personService.getAddPerson(person);
//        return new RedirectView("");
//    }

//    @GetMapping("/editClass/{id}")
//    public String getEditClass(@PathVariable Long id, Model model) {
//        Classes classesById = classesService.getClassById(id);
//        model.addAttribute("classes", classesById);
//        return "";
//    }
//
//    @PostMapping("/editClass/{id}")
//    public RedirectView postEditClass(@Valid Classes classes) {
//        classesService.getEditClass(classes);
//        return new RedirectView("");
//    }

//    @PostMapping("/deleteClass/{id}")
//    public RedirectView deleteClass(@PathVariable Long id) {
//        classesService.deleteClassById(id);
//        return new RedirectView("");
//    }


}
