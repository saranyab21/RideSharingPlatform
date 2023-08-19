package com.rideManagement.Helper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.rideManagement.model.Booking;
import com.rideManagement.model.RideSchedules;
import com.rideManagement.model.DTOs.BookingDTO;
import com.rideManagement.model.DTOs.RideDTO;

public class ApplicationMapper extends ModelMapper {
	public ApplicationMapper() {
		this.addMappings(new PropertyMap<RideDTO, RideSchedules>() {
			@Override
			protected void configure() {
				map().setRideFrom(source.getRideFrom());
				map().setRideTo(source.getRideTo());
				// Add mappings for other properties as needed
			}
		});

		this.addMappings(new PropertyMap<Booking, BookingDTO>() {
			@Override
			protected void configure() {
				map().setRideSchedulesID(source.getRideScheduleId().getId());
				// Add mappings for other properties as needed
			}
		});
	}
}
