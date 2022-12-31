package com.example.demoporject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

	@Value("${valueToReturn}")
	private String valueToReturn;
	
	@GetMapping("/sampo")
	public String hello()
	{
		return this.valueToReturn;
	}
}
