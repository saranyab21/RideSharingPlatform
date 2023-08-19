package com.rideManagement.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rideManagement.model.Booking;

public interface RideReposSearch extends JpaRepository<Booking, Integer>{

}
