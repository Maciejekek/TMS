package com.example.trainingmanagementsystem.controller;

//todo dodawanie/usuwanie/edytowanie listy bloków - done :) great connect Service and Controller

import com.example.trainingmanagementsystem.Model.ClassBlock;
import com.example.trainingmanagementsystem.service.ClassBlockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/classBlocks")
public class ClassBlockController {

    private final ClassBlockService classBlockService;

    @GetMapping
    public ResponseEntity<List<ClassBlock>> getAllClassBlocks() {
        return new ResponseEntity<>(classBlockService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassBlock> getClassBlockById(@PathVariable Long id) {
        return new ResponseEntity<>(classBlockService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postAddClassBlock(@RequestBody @Valid ClassBlock classBlock) {
        var addNewClassBlock = classBlockService.getAddClassBlock(classBlock);
        if (addNewClassBlock.getId() !=null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity patchClassBlock(@PathVariable Long id, @RequestBody ClassBlock classBlock) {
        var editClassBlock = classBlockService.getEditClassBlock(id, classBlock);
        if (editClassBlock.equals(classBlock)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClassBlock(@PathVariable Long id) {
        classBlockService.deleteClassBlock(id);

    }


//    @GetMapping("/allClassBlock")
//    public String getClassBlock(Model model) {
//        List<ClassBlock> classBlockList = classBlockService.getClassBlocksList();
//        model.addAttribute("classBlock", classBlockList);
//        return "";
//    }
//
//    @GetMapping("/addClassBlock")
//    public String getAddClassBlock() {
//        return "";
//    }
//
//    @PostMapping("/addClassBlock")
//    public RedirectView postAddClassBlock(@Valid ClassBlock classBlock) {
//        classBlockService.getAddClassBlock(classBlock);
//        return new RedirectView("");
//    }

//    @GetMapping("/editClassBlock/{id}")
//    public String getEditClassBlock(@PathVariable Long id, Model model) {
//        ClassBlock classBlockById = classBlockService.getClassBlockById(id);
//        model.addAttribute("classBlock", classBlockById);
//        return "";
//    }
//
//    @PostMapping("/editClassBlock/{id}")
//    public RedirectView postEditClass(@Valid ClassBlock classBlock) {
//        classBlockService.getEditClassBlock(classBlock);
//        return new RedirectView("");
//    }

//    @PostMapping("/deleteClass/{id}")
//    public RedirectView deleteClassBlock(@PathVariable Long id) {
//        classBlockService.deleteClassBlockById(id);
//        return new RedirectView("");
//    }


}

