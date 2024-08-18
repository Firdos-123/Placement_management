package com.example.Placement_management2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> listAll() {
        return applicationRepository.findAll();
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public Application get(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Application not found with id: " + id));
    }

    public void delete(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new NoSuchElementException("Application not found with id: " + id);
        }
        applicationRepository.deleteById(id);
    }
}
