package com.rideManagement.DAL;
import com.rideManagement.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rideManagement.model.RideSchedules;
import com.rideManagement.model.DTOs.RideDTO;
@Repository
public interface RideReposRideSchedules extends JpaRepository<RideSchedules,Integer>{

	@Query("SELECT rs FROM RideSchedules rs " +
            "WHERE (:param1 IS NULL OR rs.rideFrom = :param1) " +
            "AND (:param2 IS NULL OR rs.rideTo = :param2) " +
            "AND (:param3 IS NULL OR rs.rideFare >= :param3) " +
            "AND (:param4 IS NULL OR rs.rideFare <= :param4)")
    List<RideSchedules> search(
            @Param("param1") String param1,
            @Param("param2") String param2,
            @Param("param3") Integer param3,
            @Param("param4") Integer param4);

	@Query("SELECT r FROM RideSchedules r WHERE r.rideFrom = :from AND r.rideTo = :to AND r.rideFare BETWEEN :minPrice AND :maxPrice AND r.noOfSeatsAvailable >= :seatsAvailable")
	List<RideSchedules> findRideSchedules(@Param("from") String rideFrom, @Param("to") String rideTo, @Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice, @Param("seatsAvailable") int seatsAvailable);
//	 List<RideDTO> findByRideFromAndRideToAndRideFareBetweenAndNoOfSeatsAvailableGreaterThanEqual(
//	            String rideFrom, String rideTo, int minPrice, int maxPrice, int seatsAvailable);
	
	

//	 @Query("SELECT r.RideDTO(r.rideFrom, r.rideTo, r.rideStartsOn, r.rideTime, r.rideFare, r.vehicleRegistrationNo, r.motoristUserId, r.noOfSeatsAvailable) " +
//	            "FROM RideSchedules r " +
//	            "WHERE r.rideFrom = :rideFrom " +
//	            "AND r.rideTo = :rideTo " +
//	            "AND r.rideFare BETWEEN :minPrice AND :maxPrice " +
//	            "AND r.noOfSeatsAvailable >= :seatsAvailable")
//	    List<RideSchedules> searchRides(@Param("rideFrom") String rideFrom,
//	                              @Param("rideTo") String rideTo,
//	                              @Param("minPrice") int minPrice,
//	                              @Param("maxPrice") int maxPrice,
//	                              @Param("seatsAvailable") int seatsAvailable);
	
	

	 
}
