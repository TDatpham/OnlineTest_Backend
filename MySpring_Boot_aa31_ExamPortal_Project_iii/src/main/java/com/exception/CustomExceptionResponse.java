package com.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomExceptionResponse {
	
	public CustomExceptionResponse(String a2, String message2, String b2) {
		// TODO Auto-generated constructor stub
		this.a=a2;
		this.message=message2;
		this.b=b2;
	}
	private String a;
	private String message;
	private String b;
	
	

}
