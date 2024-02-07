package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.State;
import com.example.demo.service.StateService;

@RestController
public class StateController {
	@Autowired
	private StateService stateService;
	
	@PostMapping("/savestate")
	ResponseEntity<State> saveState(@RequestBody State state){
		State saveStates=stateService.saveState(state);
		return new ResponseEntity<>(saveStates, HttpStatus.CREATED);
	}
}
