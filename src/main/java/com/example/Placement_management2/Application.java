package com.example.Placement_management2;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "placement_id", nullable = false)
    private Long placementId;

    @Column(name = "application_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date applicationDate;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Long placementId) {
        this.placementId = placementId;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
