package com.example.Placement_management2;


import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // RESTful API methods for Retrieval operations

    @GetMapping
    public List<Students> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> get(@PathVariable Long id) {
        try {
            Students student = service.get(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Create operation

    @PostMapping
    public ResponseEntity<Students> createStudent(@RequestBody Students student) {
        try {
            Students createdStudent = service.save(student);
            return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // RESTful API method for Update operation

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Students student, @PathVariable Long id) {
        try {
            student.setId(id);
            service.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Delete operation

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
