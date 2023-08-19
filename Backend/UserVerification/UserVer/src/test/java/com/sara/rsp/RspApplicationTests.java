package com.sara.rsp;

import com.sara.rsp.entity.DTOs.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.sara.rsp.entity.UserApplication;
import com.sara.rsp.entity.DrivingLicense;
import com.sara.rsp.entity.Company;
import com.sara.rsp.entity.AuthUser;
import com.sara.rsp.repo.interfaces.IUserRepository;
import com.sara.rsp.repo.interfaces.ICompanyRepository;
import com.sara.rsp.repo.*;
import com.sara.rsp.service.UserService;
import com.sara.rsp.service.exceptions.InvalidPhoneNumber;
import com.sara.rsp.service.exceptions.InvalidAadharNumber;
import com.sara.rsp.service.exceptions.InvalidDrivingLicense;
import com.sara.rsp.service.exceptions.InvalidMotoristRegistration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RspApplicationTests {

    @Mock
    private IUserRepository userRepository;
    
    @Mock
    private ICompanyRepository companyRepository;
    
    @Mock
    private PasswordEncoder passwordEncoder;

    private UserService userService;

    @BeforeEach
    void setup() {
        ModelMapper modelMapper = new ModelMapper();
        userService = new UserService(userRepository, companyRepository, modelMapper, passwordEncoder);
    }

    
    @Test
    public void testCreateNewApplication_Successful() throws InvalidPhoneNumber, InvalidAadharNumber, InvalidDrivingLicense, InvalidMotoristRegistration {
        // Create a NewApplicationDTO object with valid application data
        NewApplicationDTO application = new NewApplicationDTO();
        application.setRoleId(2);
        application.setAadharNumber("123456789012");
        application.setPhoneNumber("9876543210");

        // Mock the behavior of the userRepository
        UserApplication userApplication = new UserApplication();
        DrivingLicense drivingLicense = new DrivingLicense();
        Mockito.when(userRepository.insertNewApplication(Mockito.any(UserApplication.class), Mockito.any(DrivingLicense.class))).thenReturn(1);

        // Call the method being tested
        boolean result = userService.createNewApplication(application);

        // Assert the result
        Assertions.assertTrue(result);
    }

    @Test
    void testCreateNewApplication_InvalidMotoristRegistration_ShouldThrowException() {
        // Arrange
        NewApplicationDTO application = new NewApplicationDTO();
        application.setRoleId(1);
        application.setAadharNumber("123456789012");
        application.setPhoneNumber("9876543210");

        // Act & Assert
        Assertions.assertThrows(InvalidMotoristRegistration.class, () -> {
            userService.createNewApplication(application);
        });
        verify(userRepository, never()).insertNewApplication(any(UserApplication.class), any(DrivingLicense.class));
    }

    @Test
    void testGetAllPendingApplications_ShouldReturnListOfPendingApplications() {
        // Arrange
        List<UserApplication> userApplications = new ArrayList<>();
        UserApplication application1 = new UserApplication();
        UserApplication application2 = new UserApplication();
        userApplications.add(application1);
        userApplications.add(application2);

        when(userRepository.getPendingApplications()).thenReturn(userApplications);
        when(userRepository.getDrivingLicense(anyInt())).thenReturn(null);

        // Act
        List<showApplicationDTO> result = userService.getAllPendingApplications();

        // Assert
        Assertions.assertEquals(2, result.size());
        verify(userRepository, times(1)).getPendingApplications();
        verify(userRepository, times(2)).getDrivingLicense(anyInt());
    }
    
    @Test
    public void testUpdateApplication_RejectedStatus_ReturnsTrue() {
        // Mock the behavior of the userRepository
        UserApplication application = new UserApplication();
        application.setUserId(1);
        Mockito.when(userRepository.getPendingApplicationByUserId(Mockito.anyInt())).thenReturn(application);
        Mockito.when(userRepository.rejectApplication(Mockito.any(UserApplication.class))).thenReturn(1);

        // Create an UpdateApplicationDTO object with rejected status
        UpdateApplicationDTO updateApplication = new UpdateApplicationDTO();
        updateApplication.setUserId(1);
        updateApplication.setApplicationStatus("Rejected");

        // Call the method being tested
        boolean result = userService.updateApplication(updateApplication);

        // Assert the result
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testUpdateApplication_ApprovedStatus_ReturnsTrue() {
        // Mock the behavior of the userRepository
        UserApplication application = new UserApplication();
        application.setUserId(1);
        Mockito.when(userRepository.getPendingApplicationByUserId(Mockito.anyInt())).thenReturn(application);
        Mockito.when(userRepository.approveApplication(Mockito.any(UserApplication.class), Mockito.any(AuthUser.class))).thenReturn(1);
        
        // Create an UpdateApplicationDTO object with approved status
        UpdateApplicationDTO updateApplication = new UpdateApplicationDTO();
        updateApplication.setUserId(1);
        updateApplication.setApplicationStatus("Approved");
        
        // Call the method being tested
        boolean result = userService.updateApplication(updateApplication);

        // Assert the result
        Assertions.assertTrue(result);
    }
        
    @Test
    public void testGetAllCompanies() {
        // Mock the behavior of the companyRepository
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1, "Company 1"));
        companies.add(new Company(2, "Company 2"));
        Mockito.when(companyRepository.getAllCompanies()).thenReturn(companies);

        // Call the method being tested
        List<Company> result = userService.getAllCompanies();

        // Assert the result
        Assertions.assertEquals(companies.size(), result.size());
    }
    
    @Test
    void testCreateNewApplication_InvalidPhoneNumber_ShouldThrowException() {
        // Arrange
        NewApplicationDTO application = new NewApplicationDTO();
        application.setRoleId(2);
        application.setAadharNumber("123456789012");
        application.setPhoneNumber("12345");

        // Act & Assert
        Assertions.assertThrows(InvalidPhoneNumber.class, () -> {
            userService.createNewApplication(application);
        });
        verify(userRepository, never()).insertNewApplication(any(UserApplication.class), any(DrivingLicense.class));
    }
    
    @Test
    public void testCreateNewApplication_InvalidDrivingLicense() {
        // Create a NewApplicationDTO object with invalid driving license
        NewApplicationDTO application = new NewApplicationDTO();
        application.setRoleId(1);
        application.setLicenseNo("ABC123XYZ");
        application.setExpirationDate(LocalDate.parse("2023-08-08"));

        // Call the method being tested and assert that it throws the expected exception
        Assertions.assertThrows(InvalidDrivingLicense.class, () -> userService.createNewApplication(application));
    }

    @Test
    public void testCreateNewApplication_InvalidAadharNumber() {
        // Create a NewApplicationDTO object with invalid Aadhar number
        NewApplicationDTO application = new NewApplicationDTO();
        application.setRoleId(2);
        application.setAadharNumber("1234567890123");

        // Call the method being tested and assert that it throws the expected exception
        Assertions.assertThrows(InvalidAadharNumber.class, () -> userService.createNewApplication(application));
    }
    
    @Test
    public void createNewApplication_MotoristNotGivingLicense_ShouldThrowException() {
        NewApplicationDTO application = new NewApplicationDTO();
        application.setUsername("Niladri");
        application.setPassword("password");
        application.setOfficialEmail("abc@gmail.com");
        application.setPhoneNumber("19876543212");
        application.setDesignation("Employee");
        application.setRoleId(1);
        application.setEmployeeId("23234");
        application.setAadharNumber("345478765674");
        application.setApplicationStatus("New");
        application.setCompanyId(1);

        Assertions.assertThrows(InvalidMotoristRegistration.class, () -> userService.createNewApplication(application));
    }
    
}
    
	
	
	
	
	
	
