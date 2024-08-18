package com.example.Placement_management2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Get all companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.listAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    // Get company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
        try {
            Company company = companyService.get(id);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.save(company);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    // Update an existing company
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        try {
            company.setId(id);
            Company updatedCompany = companyService.save(company);
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a company by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") Long id) {
        try {
            companyService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
