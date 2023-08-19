package com.sara.rsp.service;

import com.sara.rsp.entity.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sara.rsp.entity.DTOs.*;
import com.sara.rsp.repo.interfaces.*;
import com.sara.rsp.service.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;


@Service
public class UserService {
    private final IUserRepository userRepository;
    private final ICompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRepository, ICompanyRepository companyRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = new ModelMapper();
        this.passwordEncoder = passwordEncoder;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }


    public boolean createNewApplication(NewApplicationDTO application) throws InvalidPhoneNumber, InvalidAadharNumber, InvalidDrivingLicense, InvalidMotoristRegistration {
        if (application.getRoleId() == 1 && application.getLicenseNo() == null) {
            throw new InvalidMotoristRegistration("Invalid Motorist Registration: Driving License is required.");
        }

        if (application.getRoleId() == 1) {
            if (!isValidDrivingLicense(application.getLicenseNo(), application.getExpirationDate())) {
                throw new InvalidDrivingLicense("Invalid Driving License");
            }
        }

        if (application.getAadharNumber().length() != 12) {
            throw new InvalidAadharNumber("Invalid Aadhar Number");
        }

        if (application.getPhoneNumber().length() != 10 || !application.getPhoneNumber().startsWith("9")) {
            throw new InvalidPhoneNumber("Invalid Phone Number");
        }
        

        UserApplication applicationUser = modelMapper.map(application, UserApplication.class);
        
        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(application.getPassword());
        applicationUser.setPassword(encryptedPassword);
        
        DrivingLicense license = modelMapper.map(application, DrivingLicense.class);
        
        
        // Set the user_id in the DrivingLicense entity
        license.setUser(applicationUser);
        
        license.setDrivingLicenseId(applicationUser.getUserId());
            
        if (userRepository.insertNewApplication(applicationUser, license) > 0) {
            return true;
        }

        return false;
    }

    private boolean isValidDrivingLicense(String licenseNo, LocalDate expirationDate) {
        String licenseNoPattern = "^[A-Z]{3}[0-9]{4}[A-Z]{3}$";
        Pattern pattern = Pattern.compile(licenseNoPattern);

        if (!pattern.matcher(licenseNo).matches()) {
            return false;
        }

        if (expirationDate.isBefore(LocalDate.now())) {
            return false;
        }

        return true;
    }

    public List<showApplicationDTO> getAllPendingApplications() {
        List<showApplicationDTO> pendingApplications = new ArrayList<>();

        List<UserApplication> userApplications = userRepository.getPendingApplications();

        for (UserApplication application : userApplications) {
            showApplicationDTO app = modelMapper.map(application, showApplicationDTO.class);
            DrivingLicense license = userRepository.getDrivingLicense(application.getUserId());
            
            if (license != null) {
                app.setLicenseNo(license.getLicenseNo());
                app.setExpirationDate(license.getExpirationDate());
                app.setRTA(license.getRTA());
                app.setAllowedVehicles(license.getAllowedVehicles());
            }

            pendingApplications.add(app);
        }

        return pendingApplications;
    } 
        
    public showApplicationDTO getPendingApplicationById(int userId) {
        UserApplication application = userRepository.getPendingApplicationByUserId(userId);
        showApplicationDTO app = modelMapper.map(application, showApplicationDTO.class);
        DrivingLicense license = userRepository.getDrivingLicense(application.getUserId());
        
        if (license != null) {
            app.setLicenseNo(license.getLicenseNo());
            app.setExpirationDate(license.getExpirationDate());
            app.setRTA(license.getRTA());
            app.setAllowedVehicles(license.getAllowedVehicles());
        }

        return app;
    }

    public boolean updateApplication(UpdateApplicationDTO application) {
        UserApplication app = userRepository.getPendingApplicationByUserId(application.getUserId());

        if (application.getApplicationStatus().equals("Rejected")) {
            app.setApplicationStatus("Rejected");
            if (userRepository.rejectApplication(app) > 0) {
                return true;
            }
            return false;
        }

        AuthUser user = modelMapper.map(app, AuthUser.class);
        user.setEmail(app.getOfficialEmail());
        user.setPassword(app.getPassword());
        user.setPhone(app.getPhoneNumber());
        app.setApplicationStatus("Approved");

        if (userRepository.approveApplication(app, user) > 0) {
            return true;
        }

        return false;
    }
    
    public AuthUser authenticateUser(String email, String password) throws UnauthorizedException {
        AuthUser user = userRepository.findByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("Invalid email or password");
        }

        return user;
    } 
} 



