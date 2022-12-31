package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;
	
	 @GetMapping("/currency-exchange/from/{from}/to/{to}")
	 public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
	 {
		 System.out.println("in here in currency exchange");
		// CurrencyExchange ex= new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
	 
		 CurrencyExchange ex = this.repository.findByFromAndTo(from, to);
		 
		 if (ex==null)
		 {
			 throw new RuntimeException("unable to find data for " + from + "to " + to);
		 }
		 
		 String port = environment.getProperty("local.server.port");
		 ex.setEnvironment(port);
		 
		 return ex;
		 
		 
	 }
}
