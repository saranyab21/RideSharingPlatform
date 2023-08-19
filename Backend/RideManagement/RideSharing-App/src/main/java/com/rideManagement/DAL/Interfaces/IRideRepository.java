package com.rideManagement.DAL.Interfaces;


import java.util.List;

import com.rideManagement.model.Booking;
import com.rideManagement.model.Distance;
import com.rideManagement.model.RideSchedules;
import com.rideManagement.model.DTOs.FareDTO;
import com.rideManagement.model.DTOs.SearchDTO;

public interface IRideRepository {
    List<Distance> getDistances();
    int getFare(String regNo);
    int addRide(RideSchedules rideSchedule);
    int getMotoristId(String regNo);
    List<RideSchedules> search(SearchDTO searchDTO);
    int bookRide(Booking booking);
    int getRideFare(FareDTO fareDTO);
    String getRegNo(int userId);
}
