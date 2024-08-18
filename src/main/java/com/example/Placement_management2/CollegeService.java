package com.example.Placement_management2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    // Get all colleges
    public List<College> listAll() {
        return collegeRepository.findAll();
    }

    // Get college by ID
    public College get(Long id) {
        return collegeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("College not found with id: " + id));
    }

    // Save (create or update) a college
    public College save(College college) {
        return collegeRepository.save(college);
    }

    // Delete college by ID
    public void delete(Long id) {
        if (!collegeRepository.existsById(id)) {
            throw new NoSuchElementException("College not found with id: " + id);
        }
        collegeRepository.deleteById(id);
    }
}
