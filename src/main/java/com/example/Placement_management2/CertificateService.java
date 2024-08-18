package com.example.Placement_management2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public List<Certificate> listAll() {
        return certificateRepository.findAll();
    }

    public Certificate save(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public Certificate get(Long id) {
        return certificateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Certificate not found with id: " + id));
    }

    public void delete(Long id) {
        if (!certificateRepository.existsById(id)) {
            throw new NoSuchElementException("Certificate not found with id: " + id);
        }
        certificateRepository.deleteById(id);
    }
}
