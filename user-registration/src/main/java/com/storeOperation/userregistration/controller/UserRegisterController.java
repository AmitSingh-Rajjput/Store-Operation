package com.storeOperation.userregistration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeOperation.userregistration.entity.JWTAuthResponse;
import com.storeOperation.userregistration.entity.LoginDto;
import com.storeOperation.userregistration.entity.RegisterDto;
import com.storeOperation.userregistration.entity.User;
import com.storeOperation.userregistration.repository.UserRepository;
import com.storeOperation.userregistration.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class UserRegisterController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("/test")
	public ResponseEntity<String> demourl() {
		return ResponseEntity.ok("This is working");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/post")
	public ResponseEntity<String> postDemo(){
		return ResponseEntity.ok("This is the post demo");
	}
	
	// Build login REST API
	@PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }
	
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
		String response = authService.register(registerDto);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/userDetail/{username}")
	public ResponseEntity<Optional<User>> userDetail(@PathVariable("username") String user){
		Optional<User> response = authService.userDetails(user);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
}
