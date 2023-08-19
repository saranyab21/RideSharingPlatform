package com.sara.rsp.controller;

import com.sara.rsp.auth.*;
import com.sara.rsp.repo.*;
import com.sara.rsp.service.UserService;
import com.sara.rsp.service.exceptions.UnauthorizedException;
import com.sara.rsp.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    
    @Autowired
    private AuthResponseRepository authResponseRepository;


    private JwtUtil jwtUtil;
    public AuthController(UserService userService, JwtUtil jwtUtil) {
    	this.userService = userService;
        this.jwtUtil = jwtUtil;

    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginRequestModel loginReq)  {

        try {
            //Authentication authentication =
            //        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            //String email = authentication.getName();
            AuthUser user = userService.authenticateUser(loginReq.getEmail(), loginReq.getPassword());

            if (user == null) {
                throw new UnauthorizedException("Invalid email or password");
            }
            //AuthUser user = new AuthUser(email,"");
            String token = jwtUtil.createToken(user);
            //LoginRes loginRes = new LoginRes(email,token);
            
            // Prepare AuthResponse
            AuthResponse authResponse = new AuthResponse();
            authResponse.setId(user.getAuthUserId());
            authResponse.setToken(token);
            authResponse.setName(user.getUserName());
            authResponse.setRole(user.getRole().getRoleName());
            
            // Save AuthResponse in the database
            AuthResponse savedAuthResponse = authResponseRepository.save(authResponse);

            return ResponseEntity.ok(authResponse);

            //return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}