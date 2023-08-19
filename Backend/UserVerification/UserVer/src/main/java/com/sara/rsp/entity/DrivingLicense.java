package com.sara.rsp.entity;

import java.time.LocalDate;

//import javax.validation.constraints.NotEmpty;

import jakarta.persistence.*;


@Entity
public class DrivingLicense {
	
    @Id
    private int id;

    private String licenseNo;

    private LocalDate expirationDate;

    private String rta;

    private String allowedVehicles;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserApplication user;

    // Constructors, getters, and setters

    public DrivingLicense() {
        // Default constructor
    }

    // Constructor without ID (for creating new instances)
    public DrivingLicense(String licenseNo, LocalDate expirationDate, String rta, String allowedVehicles, UserApplication user) {
    	this.licenseNo = licenseNo;
        this.expirationDate = expirationDate;
        this.rta = rta;
        this.allowedVehicles = allowedVehicles;
        this.user = user;
    }

    // Add custom validation for expirationDate to ensure it is not a past date
    @PrePersist
    @PreUpdate
    private void validateExpirationDate() {
        LocalDate currentDate = LocalDate.now();
        if (expirationDate != null && expirationDate.isBefore(currentDate)) {
            throw new IllegalArgumentException("Expiration date cannot be a past date");
        }
    }

	public int getDrivngLicenseId() {
		return id;
	}

	public void setDrivingLicenseId(int id) {
		this.id = id;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getRTA() {
		return rta;
	}

	public void setRTA(String rta) {
		this.rta = rta;
	}

	public String getAllowedVehicles() {
		return allowedVehicles;
	}

	public void setAllowedVehicles(String allowedVehicles) {
		this.allowedVehicles = allowedVehicles;
	}

	public UserApplication getUser() {
		return user;
	}

	public void setUser(UserApplication user) {
		this.user = user;
	}
    
}







