package com.example.Placement_management2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Get all companies
    public List<Company> listAll() {
        return companyRepository.findAll();
    }

    // Get a company by ID
    public Company get(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> 
            new NoSuchElementException("Company not found with id: " + id)
        );
    }

    // Save or update a company
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    // Delete a company by ID
    public void delete(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new NoSuchElementException("Company not found with id: " + id);
        }
        companyRepository.deleteById(id);
    }
}
