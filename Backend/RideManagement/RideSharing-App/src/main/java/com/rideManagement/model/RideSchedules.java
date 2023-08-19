package com.rideManagement.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "RideSchedules")
public class RideSchedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "RideFrom")
    private String rideFrom;

    @Column(name = "RideTo")
    private String rideTo;

    @Temporal(TemporalType.DATE)
    @Column(name = "RideStartsOn")
    @FutureOrPresent(message = "Date must not be a past date")
    private Date rideStartsOn;

    @Column(name = "RideTime")
    private String rideTime;

    @Column(name = "RideFare")
    private int rideFare;

    @Column(name = "VehicleRegistrationNo")
    @Pattern(regexp = "^\\d{10}$", message = "Vehicle Registration Number must be 10 digits")
    private String vehicleRegistrationNo;

    @Column(name = "MotoristUserId")
    private int motoristUserId;

    @Column(name = "NoOfSeatsAvailable")
    private int noOfSeatsAvailable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRideFrom() {
        return rideFrom;
    }

    public void setRideFrom(String rideFrom) {
        this.rideFrom = rideFrom;
    }

    public String getRideTo() {
        return rideTo;
    }

    public void setRideTo(String rideTo) {
        this.rideTo = rideTo;
    }

    public Date getRideStartsOn() {
        return rideStartsOn;
    }

    public void setRideStartsOn(Date rideStartsOn) {
        this.rideStartsOn = rideStartsOn;
    }

    public String getRideTime() {
        return rideTime;
    }

    public void setRideTime(String rideTime) {
        this.rideTime = rideTime;
    }

    public int getRideFare() {
        return rideFare;
    }

    public void setRideFare(int rideFare) {
        this.rideFare = rideFare;
    }

    public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }

    public int getMotoristUserId() {
        return motoristUserId;
    }

    public void setMotoristUserId(int motoristUserId) {
        this.motoristUserId = motoristUserId;
    }

    public int getNoOfSeatsAvailable() {
        return noOfSeatsAvailable;
    }

    public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
        this.noOfSeatsAvailable = noOfSeatsAvailable;
    }
}
