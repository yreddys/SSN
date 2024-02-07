package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class State {
	@Id
	@GeneratedValue
	private int stateId;
	private String stateName;
	private String ssnPrefix;
	

}
