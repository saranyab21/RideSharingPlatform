package com.rideManagement.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RegistrationNo")
	private String registrationNo;
	
	@Column(name="BelongsToUserId")
	private int belongstouserid;
	
	@Column(name="VehicleTypeId")
	private int vehicletypeid;
	
	@Column(name="InspectionStatus")
	private String inspectionstatus;
	
	@Column(name="InspectionByUserId")
	private int inspectionbyuserid;
	
	@Column(name="InspectedOn")
	private Date inspectedon;
	
	@Column(name="FarePerKm")
	private int farePerKm;

	public int getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(int farePerKm) {
		this.farePerKm = farePerKm;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getBelongstouserid() {
		return belongstouserid;
	}

	public void setBelongstouserid(int belongstouserid) {
		this.belongstouserid = belongstouserid;
	}

	public int getVehicletypeid() {
		return vehicletypeid;
	}

	public void setVehicletypeid(int vehicletypeid) {
		this.vehicletypeid = vehicletypeid;
	}

	public String getInspectionstatus() {
		return inspectionstatus;
	}

	public void setInspectionstatus(String inspectionstatus) {
		this.inspectionstatus = inspectionstatus;
	}

	public int getInspectionbyuserid() {
		return inspectionbyuserid;
	}

	public void setInspectionbyuserid(int inspectionbyuserid) {
		this.inspectionbyuserid = inspectionbyuserid;
	}

	public Date getInspectedon() {
		return inspectedon;
	}

	public void setInspectedon(Date inspectedon) {
		this.inspectedon = inspectedon;
	}
	
	
}
