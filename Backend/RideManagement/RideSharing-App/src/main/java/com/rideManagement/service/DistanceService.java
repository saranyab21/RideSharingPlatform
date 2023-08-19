package com.rideManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rideManagement.DAL.RideRepos2;
import com.rideManagement.DAL.VehicleRepository;
import com.rideManagement.model.Distance;
import com.rideManagement.model.Vehicle;

@Service
public class DistanceService {
private final RideRepos2 distanceRepos;
private final VehicleRepository vehicleRepos;

@Autowired
public DistanceService(RideRepos2 distanceRepos, VehicleRepository vehicleRepos) {
	this.distanceRepos=distanceRepos;
	this.vehicleRepos=vehicleRepos;
}

public Integer calculateDistance(String registrationNo, Integer id) {
	Vehicle vehicle =vehicleRepos.findById(registrationNo).orElse(null);
	Distance distance=distanceRepos.findById(id).orElse(null);
	
	if(vehicle == null || distance==null) {
		return null;
	}
	return vehicle.getFarePerKm()*distance.getDistanceInKMS();
}
}
