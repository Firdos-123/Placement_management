package com.example.Placement_management2;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // Get all certificates
    @GetMapping
    public ResponseEntity<List<Certificate>> getAllCertificates() {
        List<Certificate> certificates = certificateService.listAll();
        return new ResponseEntity<>(certificates, HttpStatus.OK);
    }

    // Get certificate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable("id") Long id) {
        try {
            Certificate certificate = certificateService.get(id);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new certificate
    @PostMapping
    public ResponseEntity<Certificate> createCertificate(@RequestBody Certificate certificate) {
        Certificate createdCertificate = certificateService.save(certificate);
        return new ResponseEntity<>(createdCertificate, HttpStatus.CREATED);
    }

    // Update an existing certificate
    @PutMapping("/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable("id") Long id, @RequestBody Certificate certificate) {
        try {
            certificate.setId(id);
            Certificate updatedCertificate = certificateService.save(certificate);
            return new ResponseEntity<>(updatedCertificate, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a certificate by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable("id") Long id) {
        try {
            certificateService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
