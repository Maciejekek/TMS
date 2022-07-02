package com.example.trainingmanagementsystem.controller;

import com.example.trainingmanagementsystem.Model.ParticipantApplication;
import com.example.trainingmanagementsystem.service.ParticipantApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ParticipantApplicationController {

    ParticipantApplicationService applicationService;

    @PostMapping("/participantApplication")
    public ParticipantApplication createParticipantApplication(@RequestParam("courseId") Long courseId,@RequestParam("personId") Long personId){
        return applicationService.createParticipantApplication(courseId, personId);
    }

    @GetMapping("/participantApplication")
    public List<ParticipantApplication> getAllParticipantApplication(){
        return applicationService.getAllParticipantApplication();
    }

    @GetMapping("/participantApplication/{id}")
    public ParticipantApplication getParticipantApplicationById(@PathVariable Long id){
        return applicationService.getParticipantApplicationById(id);
    }

    @DeleteMapping("/participantApplication/accept")
    public ResponseEntity<HttpStatus> acceptParticipantApplication(@RequestParam("applicationId")Long applicationId){
        return applicationService.acceptParticipantApplication(applicationId);
    }

    @DeleteMapping("/participantApplication/decline")
    public ResponseEntity<HttpStatus> declineParticipantApplication(@RequestParam("applicationId")Long applicationId){
        return applicationService.declineParticipantApplication(applicationId);
    }
}
