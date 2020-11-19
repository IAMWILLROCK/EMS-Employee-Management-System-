package com.luv2code.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2code.springdemo.message.ResourceErrorResponse;

@ControllerAdvice
public class ResourceExceptionAdvice {

	@ExceptionHandler
	public ResponseEntity<ResourceErrorResponse> handleException(ResourceNotFoundException exc){
		// Create a Resource Error Response
		ResourceErrorResponse error = new ResourceErrorResponse(HttpStatus.NOT_FOUND.value(), 
																exc.getMessage(),
																System.currentTimeMillis());
		return new ResponseEntity<ResourceErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// Handle any Exception
	
	public ResponseEntity<ResourceErrorResponse> handleException(Exception exc){
		
		ResourceErrorResponse error = new ResourceErrorResponse(HttpStatus.BAD_REQUEST.value(),
																exc.getMessage(),
																System.currentTimeMillis());
		
		return new ResponseEntity<ResourceErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
