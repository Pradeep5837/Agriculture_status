package com.agriculture.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Crops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int crops_id;
	private String rdNum;
	private double sugarcane;
	private double ragi;
	private double wheat;
	private double maize;
	private double cotton;
	private double rice;
	private double potato;
	private double banana;
	
	
}
