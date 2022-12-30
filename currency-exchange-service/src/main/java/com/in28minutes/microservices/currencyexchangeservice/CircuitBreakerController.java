package com.in28minutes.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name="sample-api", fallbackMethod="hardcodedResponse")
	 public String sampleAPI() {
		
		logger.info("sample api call received");
		
		ResponseEntity<String> x = new RestTemplate().getForEntity("http://localhost:8080/dummy-url",String.class);
		
		return x.getBody();
		 		
	 }
	
	
	@GetMapping("/sample-api-circuit")
	//@CircuitBreaker(name="default", fallbackMethod="hardcodedResponse")
	@RateLimiter(name="default") 
	public String sampleAPIBreak() {
		
		logger.info("sample api call received breaker");
		
		//ResponseEntity<String> x = new RestTemplate().getForEntity("http://localhost:8080/dummy-url",String.class);
		
		//return x.getBody();
		
		return "sample-api";
		 		
	 }
	
	
	private String hardcodedResponse(Exception ex) {
		return "fallbackResponse!" + ex.getMessage();
	}
}
