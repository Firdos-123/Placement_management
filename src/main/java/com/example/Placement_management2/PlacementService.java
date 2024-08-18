package com.example.Placement_management2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    // Get all placements
    public List<Placement> listAll() {
        return placementRepository.findAll();
    }

    // Save a placement
    public Placement save(Placement placement) {
        return placementRepository.save(placement);
    }

    // Get a placement by ID
    public Placement get(Long id) {
        return placementRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Placement not found with id: " + id));
    }

    // Delete a placement by ID
    public void delete(Long id) {
        if (!placementRepository.existsById(id)) {
            throw new NoSuchElementException("Placement not found with id: " + id);
        }
        placementRepository.deleteById(id);
    }
}
