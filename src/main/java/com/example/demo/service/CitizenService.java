package com.example.demo.service;

import com.example.demo.entity.Citizen;

public interface CitizenService {

	Citizen saveCitizen(Citizen citizen);

	Citizen getCitizenBySSN(String citizenSSN);


}
