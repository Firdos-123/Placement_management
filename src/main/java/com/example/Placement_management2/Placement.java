package com.example.Placement_management2;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "placements")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private Long companyId;
    private String jobTitle;
    private String jobDescription;
    private BigDecimal salary;
    private LocalDate interviewDate;

    public Placement() {
    }

    // Parameterized constructor
    public Placement(Long id, Long companyId, String jobTitle, String jobDescription, BigDecimal salary, LocalDate interviewDate) {
        this.id = id;
        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.salary = salary;
        this.interviewDate = interviewDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    @Override
    public String toString() {
        return "Placement [id=" + id + ", companyId=" + companyId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
                + ", salary=" + salary + ", interviewDate=" + interviewDate + "]";
    }
}
