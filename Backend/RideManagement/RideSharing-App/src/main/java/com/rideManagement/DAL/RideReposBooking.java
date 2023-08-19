package com.rideManagement.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rideManagement.model.Booking;

public interface RideReposBooking extends JpaRepository<Booking, Integer>{

}
