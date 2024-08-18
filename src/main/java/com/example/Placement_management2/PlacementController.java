package com.example.Placement_management2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    // Get all placements
    @GetMapping
    public ResponseEntity<List<Placement>> getAllPlacements() {
        List<Placement> placements = placementService.listAll();
        return new ResponseEntity<>(placements, HttpStatus.OK);
    }

    // Get placement by ID
    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable("id") Long id) {
        try {
            Placement placement = placementService.get(id);
            return new ResponseEntity<>(placement, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new placement
    @PostMapping
    public ResponseEntity<Placement> createPlacement(@RequestBody Placement placement) {
        Placement createdPlacement = placementService.save(placement);
        return new ResponseEntity<>(createdPlacement, HttpStatus.CREATED);
    }

    // Update an existing placement
    @PutMapping("/{id}")
    public ResponseEntity<Placement> updatePlacement(@PathVariable("id") Long id, @RequestBody Placement placement) {
        try {
            placement.setId(id);
            Placement updatedPlacement = placementService.save(placement);
            return new ResponseEntity<>(updatedPlacement, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a placement by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlacement(@PathVariable("id") Long id) {
        try {
            placementService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
