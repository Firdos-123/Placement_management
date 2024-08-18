package com.example.Placement_management2;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "certificate_name", nullable = false, length = 100)
    private String certificateName;

    @Column(name = "issued_date", nullable = false)
    private Date issuedDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
}
