package com.rideManagement.Helper;
//package com.rideManagement.DAL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.context.RideDbContext;
//import com.rideManagement.DAL.Interfaces.IRideRepository;
//import com.rideManagement.model.Booking;
//import com.rideManagement.model.Distance;
//import com.rideManagement.model.RideSchedules;
//import com.rideManagement.model.DTOs.FareDTO;
//import com.rideManagement.model.DTOs.SearchDTO;
//
//public class RideRepository implements IRideRepository {
//    private final RideDbContext context;
//
//    public RideRepository(RideDbContext context) {
//        this.context = context;
//    }
//
////    public List<Distance> getDistances() {
////        return new ArrayList<>(context.getDistances());
////    }
//
//    public int addRide1(RideSchedules rideSchedule) {
//        context.getRideSchedules().add(rideSchedule);
//        return context.SaveChanges();
//    }
//
//    public int getRideFare(FareDTO fareDTO) {
//        Distance d = context.getDistances().stream()
//                .filter(distance -> distance.getID() == fareDTO.getDistanceID())
//                .findFirst()
//                .orElse(null);
//
//        if (d == null) {
//            return 0;
//        }
//
//        int f = getFare(fareDTO.getVehicleRegistrationNo()) * d.getDistanceInKMS();
//        return f;
//    }
//
//    public int getFare(String regNo) {
//        var vehicle = context.getVehicles().stream()
//                .filter(v -> v.getRegistrationNo().equals(regNo))
//                .findFirst()
//                .orElse(null);
//
//        if (vehicle == null) {
//            return 0;
//        }
//
//        var vehicleType = context.getVehicleTypes().stream()
//                .filter(vt -> vt.getID() == vehicle.getVehicleTypeId())
//                .findFirst()
//                .orElse(null);
//
//        if (vehicleType == null) {
//            return 0;
//        }
//
//        return vehicleType.getFarePerKM();
//    }
//
//    public int getMotoristId(String regNo) {
//        var vehicle = context.getVehicles().stream()
//                .filter(v -> v.getRegistrationNo().equals(regNo))
//                .findFirst()
//                .orElse(null);
//
//        return (vehicle != null) ? vehicle.getBelongsToUserId() : 0;
//    }
//
//    public List<RideSchedules> search(SearchDTO searchDTO) {
//        List<RideSchedules> rides = new ArrayList<>(context.getRideSchedules());
//
//        if (searchDTO.getFrom() != null) {
//            rides = rides.stream()
//                    .filter(rs -> rs.getRideFrom().equals(searchDTO.getFrom()))
//                    .collect(Collectors.toList());
//        }
//
//        if (searchDTO.getTo() != null) {
//            rides = rides.stream()
//                    .filter(rs -> rs.getRideTo().equals(searchDTO.getTo()))
//                    .collect(Collectors.toList());
//        }
//
//        if (searchDTO.getMaxPrice() != null) {
//            rides = rides.stream()
//                    .filter(rs -> rs.getRideFare() <= searchDTO.getMaxPrice())
//                    .collect(Collectors.toList());
//        }
//
//        if (searchDTO.getMinPrice() != null) {
//            rides = rides.stream()
//                    .filter(rs -> rs.getRideFare() >= searchDTO.getMinPrice())
//                    .collect(Collectors.toList());
//        }
//
//        return rides;
//    }
//
//    public int bookRide(Booking booking) {
//        RideSchedules rideSchedule = context.getRideSchedules().stream()
//                .filter(rs -> rs.getID() == booking.getRideSchedulesID())
//                .findFirst()
//                .orElse(null);
//
//        if (rideSchedule == null) {
//            return -1;
//        }
//
//        booking.setRideSchedule(rideSchedule);
//        booking.setTotalAmount(booking.getNoOfSeats() * rideSchedule.getRideFare());
//        context.getBookings().add(booking);
//
//        rideSchedule.setNoOfSeatsAvailable(rideSchedule.getNoOfSeatsAvailable() - booking.getNoOfSeats());
//        context.SaveChanges();
//
//        return booking.getBookingID();
//    }
//
//    public String getRegNo(int userId) {
//        var vehicle = context.getVehicles().stream()
//                .filter(v -> v.getBelongsToUserId() == userId)
//                .findFirst()
//                .orElse(null);
//
//        return (vehicle != null) ? vehicle.getRegistrationNo() : "";
//    }
//
//	@Override
//	public int addRide(RideSchedules rideSchedule) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public List<Distance> getDistances() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}

//=========================================================================================================









//




//package com.rideManagement.DAL;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.rideManagement.DAL.Interfaces.IRideRepository;
//import com.rideManagement.model.RideSchedules;
//import com.rideManagement.model.Booking;
//import com.rideManagement.model.Distance;
//import com.rideManagement.model.RideSchedules;
//import com.rideManagement.model.DTOs.FareDTO;
//import com.rideManagement.model.DTOs.SearchDTO;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
//@Repository
//public class RideRepository implements IRideRepository {
//    private final EntityManager entityManager;
//
//    public RideRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
////    public List<Distance> getDistances() {
////        Query query = entityManager.createQuery("SELECT d FROM Distance d");
////        return query.getResultList();
////    }
//
//    public int addRide(RideSchedules rideSchedule) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(rideSchedule);
//        entityManager.getTransaction().commit();
//        return rideSchedule.getId();
//    }
//
//    public int getRideFare(FareDTO fareDTO) {
//        Distance distance = entityManager.find(Distance.class, fareDTO.getDistanceID());
////        int farePerKM = getFare(fareDTO.getVehicleRegistrationNo());
//        int farePerKM=100;
//        int fare = farePerKM * distance.getDistanceInKMS();
//        return fare;
//    }
//
//    public int getFare(String regNo) {
//        Query query = entityManager.createQuery("SELECT v.farePerKm FROM Vehicle v WHERE v.registrationNo = :regNo");
//        query.setParameter("regNo", regNo);
//        Integer farePerKM = (Integer) query.getSingleResult();
//        return farePerKM != null ? farePerKM : 0;
//    }
//
//    public int getMotoristId(String regNo) {
//        Query query = entityManager.createQuery("SELECT v.belongsToUserId FROM Vehicle v WHERE v.registrationNo = :regNo");
//        query.setParameter("regNo", regNo);
//        Integer motoristId = (Integer) query.getSingleResult();
//        return motoristId != null ? motoristId : 0;
//    }
//
//    @Override
//    public List<RideSchedules> search(SearchDTO searchDTO) {
//        StringBuilder queryBuilder = new StringBuilder("SELECT r FROM RideSchedules r WHERE 1=1");
////        System.out.println(searchDTO);
//        if (searchDTO.getFrom() != null) {
//            queryBuilder.append(" AND r.rideFrom = :from");
//        }
//        if (searchDTO.getTo() != null) {
//            queryBuilder.append(" AND r.rideTo = :to");
//        }
//        if (searchDTO.getMaxPrice() != null) {
//            queryBuilder.append(" AND r.rideFare <= :maxPrice");
//        }
//        if (searchDTO.getMinPrice() != null) {
//            queryBuilder.append(" AND r.rideFare >= :minPrice");
//        }
//
//        Query query = entityManager.createQuery(queryBuilder.toString());
//
//        if (searchDTO.getFrom() != null) {
//            query.setParameter("from", searchDTO.getFrom());
//        }
//        if (searchDTO.getTo() != null) {
//            query.setParameter("to", searchDTO.getTo());
//        }
//        if (searchDTO.getMaxPrice() != null) {
//            query.setParameter("maxPrice", searchDTO.getMaxPrice());
//        }
//        if (searchDTO.getMinPrice() != null) {
//            query.setParameter("minPrice", searchDTO.getMinPrice());
//        }
//
//        return query.getResultList();
//    }
//
//    public int bookRide(Booking booking) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(booking);
//
//        RideSchedules rideSchedule = entityManager.find(RideSchedules.class, booking.getRideScheduleId());
//        rideSchedule.setNoOfSeatsAvailable(rideSchedule.getNoOfSeatsAvailable() - booking.getNoOfSeats());
//
//        entityManager.getTransaction().commit();
//        return booking.getBookingID();
//    }
//	@Override
//	public List<Distance> getDistances() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public int getFare(String regNo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	@Override
//	public int addRide(RideSchedules rideSchedule) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	@Override
//	public int getMotoristId(String regNo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	@Override
//	public int getRideFare(FareDTO fareDTO) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	@Override
//	public String getRegNo(int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//
////	@Override
////	public String getRegNo(int userId) {
////		 TODO Auto-generated method stub
////		return null;
////	}
//
//    public String getRegNo(int userId) {
//        Query query = entityManager.createQuery("SELECT v.registrationNo FROM Vehicle v WHERE v.belongsToUserId = :userId");
//        query.setParameter("userId", userId);
//        String regNo = (String) query.getSingleResult();
//        return regNo != null ? regNo : "";
//    }
//
////	@Override
////	public List<Distance> getDistances() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//}
