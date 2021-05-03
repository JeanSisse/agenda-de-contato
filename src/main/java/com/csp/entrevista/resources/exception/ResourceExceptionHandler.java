package com.csp.entrevista.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.csp.entrevista.services.exceptions.NullPointerExceptionFound;
import com.csp.entrevista.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException error, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), error.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(NullPointerExceptionFound.class)
	public ResponseEntity<StandardError> NullPointerExceptionFound (NullPointerExceptionFound error, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), error.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
	}
}
