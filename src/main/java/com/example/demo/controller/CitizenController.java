package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Citizen;
import com.example.demo.entity.CitizenResponseDTO;
import com.example.demo.entity.State;
import com.example.demo.exception.CitizenAlreadyRegisteredException;
import com.example.demo.service.CitizenService;
import com.example.demo.service.StateService;

import lombok.extern.log4j.Log4j2;

@RestController
//@RequestMapping("/ssa")
@Log4j2
public class CitizenController {
	@Autowired
	private CitizenService citizenService;
	@Autowired
	private StateService stateService;

	@PostMapping("/save")
	public ResponseEntity<CitizenResponseDTO> saveCitizen(@RequestBody Citizen citizen) throws CitizenAlreadyRegisteredException {
	    String ssnPrefix = citizen.getCitizenSSN().substring(0, 1);

	    State state = stateService.getStateBySSNPrefix(ssnPrefix);

	    // Check if the SSN already exists
	    Citizen existingCitizen = citizenService.getCitizenBySSN(citizen.getCitizenSSN());
	    if (existingCitizen != null) {
	        throw new CitizenAlreadyRegisteredException("Citizen with SSN " + citizen.getCitizenSSN() + " is already registered.");
	    }

	    citizen.setState(state);
	    Citizen response = citizenService.saveCitizen(citizen);

	    CitizenResponseDTO responseDTO = new CitizenResponseDTO(state.getStateName(), citizen.getCitizenSSN());
	    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}
}
