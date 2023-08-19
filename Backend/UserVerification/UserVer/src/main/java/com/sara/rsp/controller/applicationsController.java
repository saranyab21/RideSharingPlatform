package com.sara.rsp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sara.rsp.auth.JwtUtil;
import com.sara.rsp.entity.*;
import com.sara.rsp.entity.DTOs.*;
import com.sara.rsp.repo.*;
import com.sara.rsp.service.*;
import com.sara.rsp.service.exceptions.InvalidAadharNumber;
import com.sara.rsp.service.exceptions.InvalidDrivingLicense;
import com.sara.rsp.service.exceptions.InvalidMotoristRegistration;
import com.sara.rsp.service.exceptions.InvalidPhoneNumber;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin 
@RequestMapping("/api")
public class applicationsController {

    private UserService userService;

    @Autowired
    public applicationsController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/applications/new")
    public ResponseEntity<Object> createNewApplication(@RequestBody NewApplicationDTO application) throws InvalidPhoneNumber, InvalidAadharNumber, InvalidDrivingLicense, InvalidMotoristRegistration {
        boolean result = userService.createNewApplication(application);

        if (result) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/companies")
    public ResponseEntity<Object> getAllCompanies() {
        Object companies = userService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }
    
    @GetMapping("/applications")
    public ResponseEntity<Object> getAllPendingApplications() {
        Object pendingApplications = userService.getAllPendingApplications();
        return ResponseEntity.ok(pendingApplications);
    }

    @GetMapping("/applications/{userId}")
    public ResponseEntity<Object> getPendingApplicationByUserId(@PathVariable int userId) {
        Object application = userService.getPendingApplicationById(userId);
        return ResponseEntity.ok(application);
    }

    @PutMapping("/applications/approvereject")
    public ResponseEntity<Object> updateApplication(@RequestBody UpdateApplicationDTO application) {
        boolean result = userService.updateApplication(application);

        if (result) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

