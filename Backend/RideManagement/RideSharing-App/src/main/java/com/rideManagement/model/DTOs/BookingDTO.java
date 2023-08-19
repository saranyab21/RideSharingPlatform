package com.rideManagement.model.DTOs;
import java.time.LocalDateTime;

public class BookingDTO {
    private LocalDateTime bookedOn;
    private int riderUserId;
    private int noOfSeats;
    //private int totalAmount;
    private String paymentMode;
    private int rideSchedulesID;

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(LocalDateTime bookedOn) {
        this.bookedOn = bookedOn;
    }

    public int getRiderUserId() {
        return riderUserId;
    }

    public void setRiderUserId(int riderUserId) {
        this.riderUserId = riderUserId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    /*public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }*/

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getRideSchedulesID() {
        return rideSchedulesID;
    }

    public void setRideSchedulesID(int rideSchedulesID) {
        this.rideSchedulesID = rideSchedulesID;
    }
}
