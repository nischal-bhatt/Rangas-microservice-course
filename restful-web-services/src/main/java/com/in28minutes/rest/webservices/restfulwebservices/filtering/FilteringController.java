package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean =  new SomeBean("value1","value2","value3");
		
		MappingJacksonValue mappingJacksonValue = 
				new MappingJacksonValue(someBean);
		
		this.combineCode(mappingJacksonValue, "field2");
		
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		
		List<SomeBean> list= new ArrayList<>();
		
		list.add(new SomeBean("1","2","3"));
		list.add(new SomeBean("5","6","7"));
		list.add(new SomeBean("8","9","10"));
		
		MappingJacksonValue mappingJacksonValue = 
				new MappingJacksonValue(list);
		this.combineCode(mappingJacksonValue, "field3");
		
		return mappingJacksonValue;
	}
	
	private void combineCode(MappingJacksonValue val,String fieldName)
	
	{
           SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldName);
           FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
           val.setFilters(filters);
	}
	
}
