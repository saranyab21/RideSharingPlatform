package com.sara.rsp.entity.DTOs;

//import lombok.Data;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;


//@Data
public class NewApplicationDTO {
  @NotBlank
  private String username;

  @NotBlank
  private String password;

  private String officialEmail;

  @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
  private String phoneNumber;

  private String designation;

  private int roleId;

  private String employeeId;

  @Pattern(regexp = "^\\d{12}$", message = "Aadhar number must be 12 digits")
  private String aadharNumber;

  @Pattern(regexp = "^(New|Approved|Rejected)$", message = "Invalid Application Status")
  private String applicationStatus;

  private int companyId;

  private String licenseNo;

  @FutureOrPresent
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate expirationDate;

  private String rta;
  private String allowedVehicles;
  
  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOfficialEmail() {
		return officialEmail;
	}
	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
  
  
}

