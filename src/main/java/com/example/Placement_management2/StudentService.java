package com.example.Placement_management2;

import java.util.List;
import java.util.NoSuchElementException;

import jakarta.transaction.Transactional;  // Updated import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Students> listAll() {
        return repo.findAll();
    }

    public Students save(Students student) {
        return repo.save(student);
    }

    public Students get(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Student not found with id: " + id));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Student not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
