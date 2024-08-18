package com.example.Placement_management2;



import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    // You can define custom query methods if needed
}
