package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	  @GetMapping("/v1/person")
	  public PersonV1 getFirstVersionOfPerson() {
		  return new PersonV1("Bob Charlier");
	  }
	  
	  @GetMapping("/v2/person")
	  public PersonV2 getSecondVersionOfPerson() {
		  return new PersonV2("Bob" ,"Charlier");
	  }
	  
	  @GetMapping(path="/person", params = "version=1")
	  public PersonV1 getFirstVersionOfPersonRequestParam() {
		  return new PersonV1("amad");
	  }
	  
	  @GetMapping(path="/person/header", headers = "X-API-VERSION=1")
	  public PersonV1 getFirstVersionOfPersonHeader() {
		  return new PersonV1("amad bin kassim");
	  }
	  
	  
}
