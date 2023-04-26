package com.agriculture.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agriculture.module.Crops;
import com.agriculture.module.Farm;
import com.agriculture.module.Farmer;

@Service
public interface FarmerService {

	public Farmer saveData(Farmer farmerModule);

	public List<Farmer> getAllFarmer();

	public Object getFarmerByData(String value);
	
	public Farmer getById(int id);
	
	public Object updateFarmer(Farmer farmer,String idproof,String password);
	
	public String farmedAndUnfarmedLands();
	
	public String farmedAndUnfarmedLandsInPercentage();
	
	public String totalAcresFarmedInPercentageWithSingeleItem();
}
