package com.example.Placement_management2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    // Get all colleges
    @GetMapping
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = collegeService.listAll();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    // Get college by ID
    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable("id") Long id) {
        try {
            College college = collegeService.get(id);
            return new ResponseEntity<>(college, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new college
    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College createdCollege = collegeService.save(college);
        return new ResponseEntity<>(createdCollege, HttpStatus.CREATED);
    }

    // Update an existing college
    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable("id") Long id, @RequestBody College college) {
        try {
            college.setId(id);
            College updatedCollege = collegeService.save(college);
            return new ResponseEntity<>(updatedCollege, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a college by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable("id") Long id) {
        try {
            collegeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
