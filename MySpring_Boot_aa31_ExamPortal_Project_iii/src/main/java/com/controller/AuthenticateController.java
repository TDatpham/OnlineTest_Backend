package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.CustomUserDetails;
import com.config.UserDetailsServiceImpl;
import com.exception.CustomException;
import com.helper.JwtUtil;
import com.model.JwtRequest;
import com.model.JwtResponse;
import com.model.User;
import com.repo.UserRepo;

import antlr.collections.List;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticateController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;


	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
//======== method ==========================================================================================================================	

	private boolean authenticate(String rawPassword, String encodedPassword)
	{
	    return passwordEncoder.matches(rawPassword, encodedPassword);
	}
//============ Generate Token ================================================================================	
	/*
	  In Postman App
	  Body->raw JSON
	  	
	  	{
	  		"username":"swapnil",
	  		"password":"1234"
	  	}
	 */	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	    authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
	    final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
	    final String token = jwtUtil.generateToken(userDetails);
	    return ResponseEntity.ok(new JwtResponse(token)); // JSON response
	}
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }
	
	
	
	
	
	
	
//====================returns the details of loggedin user from CustomUserDetails ===========  // you can get role from this
	
	@GetMapping("/currentuser")
	public UserDetails getCurrentUser(Principal principal)
	{
		// return this.userRepo.findByUsername(principal.getName());
		
		return this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
	
//====================returns the details of loggedin user from User ===========  
	
		@GetMapping("/loggedinuser")
		public User getLoggedInUser(Principal principal)
		{
			 return this.userRepo.findByUsername(principal.getName());
			
			
		}	

//====================================================================================	
	
}
