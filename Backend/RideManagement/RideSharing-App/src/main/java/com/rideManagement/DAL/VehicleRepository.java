package com.rideManagement.DAL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rideManagement.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String>{

	@Query("SELECT r.registrationNo from Vehicle r where r.belongstouserid =:userId")
	String findByuserId(@Param("userId") Integer userId);
}
