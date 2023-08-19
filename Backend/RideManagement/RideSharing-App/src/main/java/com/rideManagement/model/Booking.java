package com.rideManagement.model;

import java.util.Date;
//import javax.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID")
    private int bookingID;

    @Column(name = "BookedOn")
    private Date bookedOn;

    @Column(name = "RiderUserId")
    private int riderUserId;

    @Column(name = "NoOfSeats")
    private int noOfSeats;

    @Column(name = "TotalAmount")
    private int totalAmount;

    @Column(name = "PaymentMode")
    private String paymentMode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RideScheduleID")
    private RideSchedules rideSchedule;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Date getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(Date bookedOn) {
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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public RideSchedules getRideScheduleId() {
        return rideSchedule;
    }

    public void setRideScheduleId(RideSchedules rideSchedule) {
        this.rideSchedule = rideSchedule;
    }
}