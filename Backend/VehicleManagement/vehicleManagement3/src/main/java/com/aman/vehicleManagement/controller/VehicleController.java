package com.aman.vehicleManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aman.vehicleManagement.entity.Vehicle;
import com.aman.vehicleManagement.entity.dto.RegisterVehicleDto;
import com.aman.vehicleManagement.entity.dto.UpdateVehicleRegistrationDTO;
import com.aman.vehicleManagement.entity.dto.VehicleDto;
import com.aman.vehicleManagement.service.VehicleService;
import com.aman.vehicleManagement.service.exceptions.InvalidDateException;
import com.aman.vehicleManagement.service.exceptions.InvalidRegistrationNumberException;
import com.aman.vehicleManagement.service.exceptions.InvalidVehicleException;
import com.aman.vehicleManagement.service.exceptions.NotFoundExcep;
import com.aman.vehicleManagement.service.exceptions.UserNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/api/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/addvehicle")
	public ResponseEntity<?> addVehicle(@RequestBody RegisterVehicleDto registerVehicleDto) {
		try {
			Vehicle vehicle = vehicleService.addVehicle(registerVehicleDto);

			return ResponseEntity.ok(200);
		} catch (InvalidVehicleException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (InvalidRegistrationNumberException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (InvalidDateException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAllVehicleDetailsByUserId(@PathVariable(name = "id") Integer userId) {
		try {
			VehicleDto vehicleDto = vehicleService.getVehicleDetailsByUserId(userId);
			return ResponseEntity.ok(vehicleDto);
		} catch (UserNotFoundException ex) {

			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@DeleteMapping("/{registrationNo}")
	public ResponseEntity<String> deleteVehicleDetailsByRegistrationNo(
			@PathVariable(name = "registrationNo") String regNo) {
//		vehicleService.deleteVehicleDetailByResigtrationNo(regNo);
		try {
			vehicleService.deleteVehicleDetailByResigtrationNo(regNo);
			return ResponseEntity.ok("Vehicle details deleted successfully.");
		} catch (NotFoundExcep ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete vehicle details.");
		}

	}

//	@GetMapping("/pendingapprovals/{pageno}")
//	public List<VehicleDto> getPendingVehicles(@PathVariable(name="pageno") Integer pageNo){
//		return vehicleService.getAllPendingVehicles(pageNo);
//	}
	@GetMapping("/pendingapprovals")
	public ResponseEntity<?> getPendingVehicles() {
		var r = vehicleService.getAllPendingVehicles();
		return ResponseEntity.ok(r);
	}

	@PutMapping("/approveorreject")
	public ResponseEntity<?> updateVehicleStatus(
			@RequestBody UpdateVehicleRegistrationDTO updateVehicleRegistrationDTO) {
		boolean result = vehicleService.updateVehicleStatus(updateVehicleRegistrationDTO);
		if (result) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}

}
