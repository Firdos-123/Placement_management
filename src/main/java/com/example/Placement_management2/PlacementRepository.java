package com.example.Placement_management2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacementRepository extends JpaRepository<Placement, Long> {
    // Additional query methods can be defined here if needed
}
