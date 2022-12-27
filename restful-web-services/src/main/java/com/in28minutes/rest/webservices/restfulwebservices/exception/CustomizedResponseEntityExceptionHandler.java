package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage()+"nisuu",request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundExceptions(Exception ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage()+"nisuu",request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request)
	{
		List<FieldError> errors = ex.getFieldErrors();
		
		String error = "";
		
		for (int i =0; i<errors.size(); i++)
		{
			error = error + " "+ errors.get(i).getDefaultMessage();
		}
		
ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), error,request.getDescription(false));
		System.out.println("hi in here now");
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
	}
}
