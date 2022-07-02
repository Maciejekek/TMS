package com.example.trainingmanagementsystem.service;

import com.example.trainingmanagementsystem.Model.ParticipantApplication;
import com.example.trainingmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.trainingmanagementsystem.repository.ParticipantApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantApplicationService {

    ParticipantApplicationRepository applicationRepository;
    CourseService courseService;

    public ParticipantApplication createParticipantApplication(Long courseId, Long personId){
        ParticipantApplication application = new ParticipantApplication();
        application.setCourseId(courseId);
        application.setPersonId(personId);
        return applicationRepository.save(application);
    }

    public List<ParticipantApplication> getAllParticipantApplication() {
        return applicationRepository.findAll();
    }

    public ParticipantApplication getParticipantApplicationById(Long id) {
        return applicationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application with id:" + id + "not found"));
    }

    public ResponseEntity<HttpStatus> acceptParticipantApplication(Long applicationId) {
        ParticipantApplication application = applicationRepository
                .findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application with id:" + applicationId + "not found"));

        courseService.addPersonInToCourse(application.getCourseId(), application.getPersonId());

        applicationRepository.delete(application);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> declineParticipantApplication(Long applicationId) {
        ParticipantApplication application = applicationRepository
                .findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application with id:" + applicationId + "not found"));
        applicationRepository.delete(application);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
