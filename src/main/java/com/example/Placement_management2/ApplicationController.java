package com.example.Placement_management2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Get all applications
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.listAll();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    // Get application by ID
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Long id) {
        try {
            Application application = applicationService.get(id);
            return new ResponseEntity<>(application, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new application
    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application createdApplication = applicationService.save(application);
        return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
    }

    // Update an existing application
    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable("id") Long id, @RequestBody Application application) {
        try {
            application.setId(id);
            Application updatedApplication = applicationService.save(application);
            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an application by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") Long id) {
        try {
            applicationService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
