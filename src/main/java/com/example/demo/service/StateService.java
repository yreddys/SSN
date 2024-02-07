package com.example.demo.service;

import com.example.demo.entity.State;

public interface StateService {

	State getStateBySSNPrefix(String ssnPrefix);

	State saveState(State state);

}
