package com.agriculture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.agriculture.module.Farm;
import com.agriculture.service.FarmService;

@RestController
public class FarmController {

	@Autowired
	FarmService fs;

	// getting the total Acres of Farms
	@GetMapping("getTotalAcreChickenFarm")
	public String getTotalAcreChickenFarm() {
		return fs.getTotalAcreChickenFarm();
	}

	@GetMapping("getTotalAcreSheepFarm")
	public String getTotalAcreSheepFarm() {
		return fs.getTotalAcreSheepFarm();
	}

	@GetMapping("getTotalAcreFishFarm")
	public String getTotalAcreFishFarm() {
		return fs.getTotalAcreFishFarm();
	}

	@GetMapping("getTotalAcreGoteFarm")
	public String getTotalAcreGoteFarm() {
		return fs.getTotalAcreGoteFarm();
	}

	@GetMapping("getTotalAcrePigFarm")
	public String getTotalAcrePigFarm() {
		return fs.getTotalAcrePigFarm();
	}

	// Getting total Acres of farm based on there data

	@GetMapping("getTotalAcresChickenFarmByFarmerDAta")
	public String getTotalAcresChickenFarmByFarmerDAta(@RequestHeader String data) {

		return fs.getTotalAcreChickenFarmByFarmerData(data);
	}

	@GetMapping("getTotalAcresSheepFarmByFarmerDAta")
	public String getTotalAcresSheepFarmByFarmerDAta(@RequestHeader String data) {

		return fs.getTotalAcreSheepFarmByFarmerData(data);
	}

	@GetMapping("getTotalAcresFishFarmByFarmerDAta")
	public String getTotalAcresFishFarmByFarmerDAta(@RequestHeader String data) {

		return fs.getTotalAcreFishFarmByFarmerData(data);
	}

	@GetMapping("getTotalAcresGoteFarmByFarmerDAta")
	public String getTotalAcresGoteFarmByFarmerDAta(@RequestHeader String data) {

		return fs.getTotalAcreGoteFarmByFarmerData(data);
	}

	@GetMapping("getTotalAcresPigFarmByFarmerDAta")
	public String getTotalAcresPigFarmByFarmerDAta(@RequestHeader String data) {

		return fs.getTotalAcrePigFarmByFarmerData(data);
	}

	// Total Acres of farms
	@GetMapping("totalAcresOfFarms")
	public String totalAcresOfFarms() {
		return fs.totalAcresOfFarm();
	}

	// Update Farm

	@PutMapping("updateFarm/{idproof}/{password}")
	public ResponseEntity<Object> updateFarm(@PathVariable("idproof") String idproof,
			@PathVariable("password") String password, @RequestBody Farm farm) {

		return new ResponseEntity<Object>(fs.updateFarm(idproof, password, farm), HttpStatus.CREATED);
	}

}
