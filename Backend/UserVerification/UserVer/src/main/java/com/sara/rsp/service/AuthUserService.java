package com.sara.rsp.service;

/*import com.sara.rsp.entity.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sara.rsp.repo.interfaces.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthUserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthUserService(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createKnownUsers() {
        AuthUser authUser1 = new AuthUser();
        authUser1.setUserName("Avishek Ray");
        authUser1.setEmail("sh@cts.com");
        authUser1.setRoleId(3); //Security Head
        authUser1.setPhone("9234567890");
        String password1 = "sh@123"; // Known password
        authUser1.setPassword(passwordEncoder.encode(password1));
        userRepository.insertAuthUser(authUser1);

        AuthUser authUser2 = new AuthUser();
        authUser2.setUserName("Aakash Ghosh");
        authUser2.setEmail("rider@cts.com");
        authUser2.setRoleId(2); //Rider
        authUser2.setPhone("9876543210");
        String password2 = "rider@123"; // Known password
        authUser2.setPassword(passwordEncoder.encode(password2));
        userRepository.insertAuthUser(authUser2);
        
        
        AuthUser authUser3 = new AuthUser();
        authUser3.setUserName("Alok Gupta");
        authUser3.setEmail("motorist@cts.com");
        authUser3.setRoleId(1); //Motorist
        authUser3.setPhone("9234567890");
        String password3 = "motorist@123"; // Known password
        authUser3.setPassword(passwordEncoder.encode(password3));
        userRepository.insertAuthUser(authUser3);
        
        AuthUser authUser4 = new AuthUser();
        authUser4.setUserName("Anshuman Ghosh");
        authUser4.setEmail("sh2@tcs.com");
        authUser4.setRoleId(3);
        authUser4.setPhone("9234567890");
        String password4 = "sh2@123"; // Known password
        authUser4.setPassword(passwordEncoder.encode(password4));
        userRepository.insertAuthUser(authUser4); 
        
    }
} */
