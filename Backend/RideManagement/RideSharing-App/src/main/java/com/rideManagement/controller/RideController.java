package com.rideManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rideManagement.DAL.RideRepos2;
import com.rideManagement.DAL.RideReposBooking;
import com.rideManagement.DAL.RideReposRideSchedules;
import com.rideManagement.DAL.VehicleRepository;
import com.rideManagement.model.Booking;
import com.rideManagement.model.Distance;
import com.rideManagement.model.RideSchedules;
import com.rideManagement.model.DTOs.RideDTO;
import com.rideManagement.model.DTOs.SearchDTO;
import com.rideManagement.service.DistanceService;

@Configuration
@RestController
@CrossOrigin
@RequestMapping("api/")
public class RideController {

	@Autowired
	RideRepos2 myriderepos2;

	@GetMapping("distances")
	public List<Distance> getAllDistances() {
		return myriderepos2.findAll();
	}

	private DistanceService distanceService = null;

//	@Autowired
//	public void DistanceController(DistanceService distanceService) {
//		this.distanceService = distanceService;
//	}

//    @Autowired
//    private RideRepos2 ridefare;
	@GetMapping("rides/calculatefare")
	public ResponseEntity<Integer> calculateDistance(@RequestParam("registrationNo") String registrationNo,
			@RequestParam("id") Integer id) {
		Integer calcDist = distanceService.calculateDistance(registrationNo, id);
		if (calcDist == null) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok(calcDist);

	}

	@Autowired
	private RideReposRideSchedules rSchedulerepo;
	@PostMapping("rides/schedule")
	public RideSchedules saveData(@RequestBody RideSchedules newRideSchedules) {
		return rSchedulerepo.save(newRideSchedules);

	}



	@GetMapping("rides/search")
	public List<RideSchedules> searchRides(SearchDTO searchCriteria) {
		 String rideFrom = searchCriteria.getFrom();
	        String rideTo = searchCriteria.getTo();
	        int minPrice = searchCriteria.getMinPrice();
	        int maxPrice = searchCriteria.getMaxPrice();
	        int seatsAvailable=1;
//	      return rideSchedulesRepository.findByRideFromAndRideToAndRideFareBetweenAndNoOfSeatsAvailableGreaterThanEqual(
//	                rideFrom, rideTo, minPrice, maxPrice, seatsAvailable);
	      return rSchedulerepo.findRideSchedules(rideFrom, rideTo, minPrice, maxPrice, seatsAvailable);
	      
	}
	

	@Autowired
	private RideReposBooking bookings;

	@PostMapping("rides/book")
	public Booking saveData(@RequestBody Booking newbooking) {
		return bookings.save(newbooking);
	}

	@Autowired
	private VehicleRepository rveclrepos;
	 @GetMapping("GetRegNo")
   public ResponseEntity<String> getRegNo(@RequestParam("userId") Integer userId) {
		 
       String r = rveclrepos.findByuserId(userId);
       return ResponseEntity.ok(r);
   }
}


































//private final EntityManager context;
//private final RideService service;			

//@Autowired
//public RideController(Context context, ModelMapper mapper) {
//  this.context = this.context;
//  this.service = new RideService(context, mapper);
//}

//private final RideDbContext context;
//private final RideService service;

//private final ModelMapper modelMapper;  // Add ModelMapper
//@Autowired
//public RideController(EntityManager context, ModelMapper modelMapper) {
//  this.context = context;
//  this.modelMapper = modelMapper;
//  this.service = new RideService(context, modelMapper);  // Pass modelMapper to RideService
//}

//public ResponseEntity<Object> getRideFare(@RequestParam("param1") String param1, @RequestParam("param2") int param2){
//return 
//}
//public ResponseEntity<Object> getRideFare(@RequestParam("param1") String param1, @RequestParam("param2") int param2) {
//FareDTO fareDTO=new FareDTO();
//fareDTO.setDistanceID(param2);
//fareDTO.setVehicleRegistrationNo(param1);
//Object r = service.getFare(fareDTO);
//
//return ResponseEntity.ok(r);
//}

//    public ResponseEntity<Object> scheduleRide(@RequestBody RideDTO rideDTO) {

//      Object r = service.scheduleRide(rideDTO);
//      return ResponseEntity.ok(r);

//  }

//  public List<Object> searchRides(@RequestParam("param1") String param1,@RequestParam("param2") String param2,@RequestParam("param3") int param3,@RequestParam("param4") int param4  ) {
//	SearchDTO searchDTO= new SearchDTO();
//	searchDTO.setFrom(param1);
//	searchDTO.setTo(param2);
//	searchDTO.setMinPrice(param3);
//	searchDTO.setMaxPrice(param4);
//	
//	Object r = service.searchRide(searchDTO);

//    return ResponseEntity.ok(r);
//}

//    public ResponseEntity<Object> bookRide(@RequestBody BookingDTO bookingDTO) {
//        Object r = service.bookRide(bookingDTO);
//        return ResponseEntity.ok(r);
//    }

//    @GetMapping("GetRegNo/{userId}")
//    public ResponseEntity<Object> getRegNo(@RequestParam int userId) {
//        Object r = service.getRegNo(userId);
//        return ResponseEntity.ok(r);
//    }
//}
