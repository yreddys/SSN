package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CitizenAlreadyRegisteredExceptionHandling {
	@ExceptionHandler(CitizenAlreadyRegisteredException.class)
	ResponseEntity<String> handlingMethod(CitizenAlreadyRegisteredException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.CREATED);

	}
}
