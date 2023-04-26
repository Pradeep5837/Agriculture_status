package com.agriculture.module;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Farm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rdnumb;
	private double chicken;
	private double sheep;
	private double fish;
	private double gote;
	private double pig;
	

}
