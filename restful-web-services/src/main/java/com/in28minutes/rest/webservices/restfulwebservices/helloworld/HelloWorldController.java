package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource msgSource)
	{
		this.messageSource = msgSource;
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "Hello World nish is here";
	}
	
	@GetMapping(path = "/hello-world1")
    public String hi()
    {
		return "hey";
    }
	
	@GetMapping(path = "/hello-world-bean")
    public HelloWorldBean hibean()
    {
		return new HelloWorldBean("hey nishi b");
    }
	
	/*
	 *  how are our requests getting handled?
	 *  DispatcherServlet is the front controller pattern
	 *  
	 * 
	 */
	
	@GetMapping(path = "/hello-world/path-variable/{name}/{number}")
	public HelloWorldBean helloWorldPathVar(@PathVariable String name, @PathVariable int number)
	{
		System.out.println(number);
		return new HelloWorldBean(name);
	}
	
	@GetMapping(path="/hello-world-i18n")
	public String helloWorldInternationalized()
	{
		Locale locale = LocaleContextHolder.getLocale();
		return this.messageSource.getMessage("good.morning.message", null,"defalt msg",locale);
	}
}
