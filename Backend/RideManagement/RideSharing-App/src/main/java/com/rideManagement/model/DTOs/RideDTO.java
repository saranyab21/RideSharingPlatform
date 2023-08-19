package com.rideManagement.model.DTOs;

import java.time.LocalDate;

public class RideDTO {
    private String rideFrom;
    private String rideTo;
    private LocalDate rideStartsOn;
    private String rideTime;
    private int rideFare;
    private String vehicleRegistrationNo;
    private int motoristUserId;
    private int noOfSeatsAvailable;

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

    public LocalDate getRideStartsOn() {
        return rideStartsOn;
    }

    public void setRideStartsOn(LocalDate rideStartsOn) {
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
