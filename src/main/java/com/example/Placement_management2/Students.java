package com.example.Placement_management2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")

public class Students {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private Double cgpa;
	
    public Students() {
    }

    // Parameterized constructor
    public Students(Long id, String name, String email, String phone, String department, Double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.cgpa = cgpa;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", department="
				+ department + ", cgpa=" + cgpa + "]";
	}
    
   

}
