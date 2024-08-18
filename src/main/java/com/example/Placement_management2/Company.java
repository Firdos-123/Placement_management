package com.example.Placement_management2;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String location;
    private String industry;

    // Default constructor
    public Company() {
    }

    // Parameterized constructor
    public Company(Long id, String companyName, String location, String industry) {
        this.id = id;
        this.companyName = companyName;
        this.location = location;
        this.industry = industry;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", companyName=" + companyName + ", location=" + location + ", industry=" + industry + "]";
    }
}
