package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.State;
import com.example.demo.repository.StateRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StateServiceImpl implements StateService {
	@Autowired
	private StateRepository stateRepository;

	@Override
	public State getStateBySSNPrefix(String ssnPrefix) {
		log.info("Fetching state by SSN prefix: {}", ssnPrefix);
		State state = stateRepository.findBySsnPrefix(ssnPrefix);
		if (state == null) {
			log.warn("No state found for SSN prefix: {}", ssnPrefix);
		} else {
			log.info("Found state: {} for SSN prefix: {}", state.getStateName(), ssnPrefix);
		}
		return state;
	}

	@Override
	public State saveState(State state) {

		return stateRepository.save(state);
	}
}
