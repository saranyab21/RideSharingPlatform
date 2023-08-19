package com.rideManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="VehicleTypes")
public class VehicleTypes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="Type")
	private int type;
	
	@Column(name="MaxPassengersAllowed")
	private int maxPassengersAllowed;
	
	@Column(name="FarePerKm")
	private int farePerKm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMaxPassengersAllowed() {
		return maxPassengersAllowed;
	}

	public void setMaxPassengersAllowed(int maxPassengersAllowed) {
		this.maxPassengersAllowed = maxPassengersAllowed;
	}

	public int getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(int farePerKm) {
		this.farePerKm = farePerKm;
	}

}
