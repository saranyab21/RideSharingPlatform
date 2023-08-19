package com.sara.rsp.entity;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private String buildingName;
    private String securityInChargeName;
    
    @Pattern(regexp = "^\\d{10}$", message = "Security Help Desk number must be 10 digits")
    private String securityHelpDeskNumber;
    
    public Company() {
        // Default constructor
    }

	public Company(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getCompanyId() {
		return id;
	}

	public void setCompanyId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getSecurityInChargeName() {
		return securityInChargeName;
	}

	public void setSecurityInChargeName(String securityInChargeName) {
		this.securityInChargeName = securityInChargeName;
	}

	public String getSecurityHelpDeskNumber() {
		return securityHelpDeskNumber;
	}

	public void setSecurityHelpDeskNumber(String securityHelpDeskNumber) {
		this.securityHelpDeskNumber = securityHelpDeskNumber;
	}
    
    

}
