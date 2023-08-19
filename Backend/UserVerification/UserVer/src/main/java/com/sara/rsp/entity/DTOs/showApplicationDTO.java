package com.sara.rsp.entity.DTOs;

//import lombok.Data;

import java.time.LocalDate;

//@Data
public class showApplicationDTO {
  private int userId;
  private String username;
  private String officialEmail;
  private String phoneNumber;
  private String designation;
  private int roleId;
  private String employeeId;
  private String aadharNumber;
  private String applicationStatus;
  private int companyId;
  private String licenseNo;
  private LocalDate expirationDate;
  private String rta;
  private String allowedVehicles;
  
  
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

