package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Citizen {
	@Id
	@GeneratedValue
	private Long id;
	private String citizenName;
	private String citizenDOB;
	private String citizenSSN;

	@OneToOne
	private State state;
	
}
