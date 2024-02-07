package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Citizen;
import com.example.demo.repository.CitizenRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CitizenServiceImpl implements CitizenService {
	@Autowired
	private CitizenRepository citizenRepository;

	@Override
	public Citizen saveCitizen(Citizen citizen) {

		log.info("Saving citizen with SSN: {}", citizen.getCitizenSSN());
        Citizen savedCitizen = citizenRepository.save(citizen);
        log.info("Citizen saved successfully with ID: {}", savedCitizen.getId());
        return savedCitizen;

}

	@Override
	public Citizen getCitizenBySSN(String citizenSSN) {
		   log.info("Fetching citizen by SSN: {}", citizenSSN);
	        return citizenRepository.findByCitizenSSN(citizenSSN);
}
}