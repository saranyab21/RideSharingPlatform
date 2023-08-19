//package com.rideManagement.context;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.management.relation.Role;
//
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Component;
//
//import com.rideManagement.authentication.models.AuthUser;
//import com.rideManagement.microservices.incidentManagement.models.*;
//import com.rideManagement.microservices.rideManagement.models.*;
//import com.rideManagement.microservices.userVerification.models.*;
//import com.rideManagement.microservices.vehicleManagement.models.*;
//import com.rideManagement.model.Booking;
//import com.rideManagement.model.Distance;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//
//@Component
//@EnableJpaRepositories(basePackages = "com.rideManagement.context")
//@Entity
//@Table(name = "rideDbContext")
//public class RideDbContext {
//
//    // microservice-user verification
//    public List<Company> companies;
//    public List<UserApplication> userApplications;
//    public List<DrivingLicense> drivingLicenses;
//    public List<Role> roles;
//    public List<AuthUser> authUsers;
//
//    // microservice-vehicle management
//    public List<Vehicle> vehicles;
//    public List<VehicleDetail> vehicleDetails;
//    public List<VehicleType> vehicleTypes;
//
//    // microservice-ride management
//    public List<Booking> bookings;
//    public List<Distance> distances;
//    public List<RideSchedule> rideSchedules;
//
//    // microservices-incident management
//    public List<Incident> incidents;
//    public List<IncidentTypes> incidentTypes;
//    public List<InvestigationDetails> investigationDetails;
//
//    public RideDbContext() {
//        initializeData();
//    }
//
//    private void initializeData() {
//        companies = new ArrayList<>();
//        companies.add(new Company(1, "Cognizant", "Unitech", "Amit Sau", "92123456789"));
//
//        userApplications = new ArrayList<>();
//        userApplications.add(new UserApplication(1, "Niladri", "niladri@cts.com", "9123456789",
//                "Intern", 1, "345678", "786556784567", "New", 1, "Niladri@123"));
//
//        drivingLicenses = new ArrayList<>();
//        drivingLicenses.add(new DrivingLicense(1, "FER6578HYU", LocalDate.parse("2023-07-19"),
//                "Beltala", "Bike", 1));
//
//        roles = new ArrayList<>();
//        roles.add(new Role(1, "Motorist"));
//        roles.add(new Role(2, "Rider"));
//        roles.add(new Role(3, "SecurityHead"));
//
//        authUsers = new ArrayList<>();
//        authUsers.add(new AuthUser(1, "Amit Sau", "amit@cts.com", "92123456789",
//                "Amit@123", 3));
//
//        vehicles = new ArrayList<>();
//        vehicleDetails = new ArrayList<>();
//        vehicleTypes = new ArrayList<>();
//
//        vehicleTypes.add(new VehicleType(1, "SUV", 7, 13));
//        vehicleTypes.add(new VehicleType(2, "Sedan", 4, 12));
//        vehicleTypes.add(new VehicleType(3, "2Wheeler", 1, 9));
//
//        distances = new ArrayList<>();
//        distances.add(new Distance(1, "Unitech", "Dunlop", 10));
//        distances.add(new Distance(2, "Unitech", "SlatLake", 5));
//
//        incidents = new ArrayList<>();
//        incidentTypes = new ArrayList<>();
//        investigationDetails = new ArrayList<>();
//
//        incidentTypes.add(new IncidentTypes(1, "Accident", 1));
//        incidentTypes.add(new IncidentTypes(2, "Theft", 2));
//        incidentTypes.add(new IncidentTypes(3, "Driver Misbehave", 1));
//    }
//}




package com.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.rideManagement.model.Booking;
import com.rideManagement.model.Distance;
import com.rideManagement.model.RideSchedules;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Component
@EnableJpaRepositories(basePackages = "com.rideManagement.context")
@Entity
@Table(name = "rideDbContext")
public class RideDbContext {

    public List<Booking> bookings;
    public List<Distance> distances;
    public List<RideSchedules> rideSchedules;

    public RideDbContext() {
        initializeData();
    }

    private void initializeData() {
        bookings = new ArrayList<>();
        distances = new ArrayList<>();
        rideSchedules = new ArrayList<>();
    }

	public Object getDistances() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RideSchedules> getRideSchedules() {
		// TODO Auto-generated method stub
		return null;
	}

}

