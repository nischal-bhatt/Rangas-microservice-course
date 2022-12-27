package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String returmBack = "hey";
	public UserNotFoundException(String message) {
		super(message);
	}
	public String getReturmBack() {
		return returmBack;
	}
	public void setReturmBack(String returmBack) {
		this.returmBack = returmBack;
	}
	
	
}
