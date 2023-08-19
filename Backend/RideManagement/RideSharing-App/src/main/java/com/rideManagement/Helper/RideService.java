package com.rideManagement.Helper;
//package com.rideManagement.service;
//import org.modelmapper.ModelMapper;
//
//import com.rideManagement.DAL.RideRepository;
//import com.rideManagement.DAL.Interfaces.IRideRepository;
//import com.rideManagement.model.Booking;
//import com.rideManagement.model.DTOs.BookingDTO;
//
//import jakarta.persistence.EntityManager;
//
//public class RideService {
//    private EntityManager context;// An instance of EntityManager representing the context or connection to the persistence layer.
//    private IRideRepository repository;// an instance of iriderepository.
//    private ModelMapper mapper;
//
//    public RideService(EntityManager context, ModelMapper mapper) {// constructor accepts entitymanager and modelmapper objects as parameters
//        this.context = context;
//        this.repository = new RideRepository(context);
//        this.mapper = mapper;
//    }
//
//    public List<Distance> getDistances() {//retrieves a list of Distance objects from method getDistance().
//        return repository.getDistances();
//        
//    }
//
//    
//    public boolean scheduleRide(RideDTO ride) {
//        Distance d = ((Collection<Distance>) getDistances()).stream()
//                .filter(v -> v.getFrom().equals(ride.getRideFrom()) && v.getTo().equals(ride.getRideTo()))//returns Distance object that matches with RideRTO
//                .findFirst()
//                .orElse(null);
//        
//        RideSchedules rideSchedule = mapper.map(ride, RideSchedules.class);
//        rideSchedule.setRideFare(repository.getFare(ride.getVehicleRegistrationNo()) * d.getDistanceInKMS());//sets the fare by calling fare from vehicleregno multiplied with distinkms
//        rideSchedule.setMotoristUserId(repository.getMotoristId(ride.getVehicleRegistrationNo()));// sets motoristuserid
//
//        int r = repository.addRide(rideSchedule);
//        return r > 0;
//    }
////
//    public List<RideSchedules> searchRide(SearchDTO ride) {
//        return repository.search(ride);
//    }
//
//    public int bookRide(BookingDTO bookingDTO) {
//        Booking booking = mapper.map(bookingDTO, Booking.class);
//        return repository.bookRide(booking);
//    }
//    }
//
//    public int getFare(FareDTO fare) {
//        return repository.getRideFare(fare);
//    }
//
//    public String getRegNo(int userId) {
//        return repository.getRegNo(userId);
//    }
//}
