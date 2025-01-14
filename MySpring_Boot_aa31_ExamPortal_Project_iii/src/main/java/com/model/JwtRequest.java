package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
	
	String username;
	String password;
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

}
