package com.agriculture.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Farmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int farmer_id;
	private String name;
	private int age;
	private long phoneNumber;
	private long aadharNumber;
	private String rdNumber;
	private String state;
	private String district;
	private String village;
	private String password;
	private double acres;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(cascade = CascadeType.ALL)
	private Crops crops;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(cascade = CascadeType.ALL)
	private Farm farm;
}
