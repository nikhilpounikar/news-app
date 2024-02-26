package com.authentication.AuthenticationService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.authentication.AuthenticationService.Models.User;
import com.authentication.AuthenticationService.RequestBodyClasses.LoginRequest;
import com.authentication.AuthenticationService.RequestBodyClasses.RegisterRequest;
import com.authentication.AuthenticationService.Services.UserService;
import com.authentication.AuthenticationService.Utilities.JwtAuthenticationResponse;
import com.authentication.AuthenticationService.Utilities.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
    	
    	boolean isUserPresent = userService.isUserExits(registerRequest.getUsername());
    	
    	if(isUserPresent) {
    		new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
    	}
       
    	User user =userService.registerUser(registerRequest.getUsername(), registerRequest.getPassword());
      
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticateUser() {
        // Your authentication logic here, you can return the user details or just a success message
        return ResponseEntity.ok("User authenticated successfully");
    }
}
