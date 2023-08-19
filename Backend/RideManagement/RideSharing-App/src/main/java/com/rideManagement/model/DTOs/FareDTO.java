package com.rideManagement.model.DTOs;

public class FareDTO {
    private String vehicleRegistrationNo;
    private int distanceID;

    public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }

    public int getDistanceID() {
        return distanceID;
    }

    public void setDistanceID(int distanceID) {
        this.distanceID = distanceID;
    }
}
