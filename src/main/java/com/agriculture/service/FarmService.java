package com.agriculture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriculture.module.Farm;
import com.agriculture.module.Farmer;

@Service
public interface FarmService {

	public Farm saveData(Farm farm);

	// get Total Acres of Farms

	public String getTotalAcreChickenFarm();

	public String getTotalAcreSheepFarm();

	public String getTotalAcreFishFarm();

	public String getTotalAcreGoteFarm();

	public String getTotalAcrePigFarm();

	// Get total acre of Farms based on the farmer data entered in database

	public String getTotalAcreChickenFarmByFarmerData(String value);

	public String getTotalAcreSheepFarmByFarmerData(String value);

	public String getTotalAcreFishFarmByFarmerData(String value);

	public String getTotalAcreGoteFarmByFarmerData(String value);

	public String getTotalAcrePigFarmByFarmerData(String value);

	// Total Acres of Farms
	public String totalAcresOfFarm();

	// update the Farms
	public Object updateFarm(String idproof, String password, Farm farm);

}
