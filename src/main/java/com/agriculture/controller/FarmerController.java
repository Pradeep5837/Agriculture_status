package com.agriculture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.agriculture.module.Crops;
import com.agriculture.module.Farm;
import com.agriculture.module.Farmer;
import com.agriculture.service.CropsService;
import com.agriculture.service.FarmService;
import com.agriculture.service.FarmerService;

@RestController
public class FarmerController {

	@Autowired
	FarmerService afs;
	@Autowired
	CropsService cs;
	@Autowired
	FarmService fs;

	@PostMapping("saveData")
	public ResponseEntity<Farmer> saveData(@RequestBody Farmer farmer) {
		ResponseEntity<Farmer> f = new ResponseEntity<Farmer>(afs.saveData(farmer), HttpStatus.CREATED);

		new ResponseEntity<Crops>(cs.saveData(farmer.getCrops()), HttpStatus.CREATED);
		new ResponseEntity<Farm>(fs.saveData(farmer.getFarm()), HttpStatus.CREATED);
		return f;

	}

	@GetMapping("getAllFarmer")
	public List<Farmer> getAllFarmer() {

		return afs.getAllFarmer();
	}

	@GetMapping("getFarmerByData")
	public Object getFarmerByData(@RequestHeader String data) {
		return afs.getFarmerByData(data);
	}

	@PutMapping("updateFarmer/{value}/{password}")
	public ResponseEntity<Object> updateFarmer(@PathVariable("value") String value,
			@PathVariable("password") String password, @RequestBody Farmer farmer) {

		return new ResponseEntity<Object>(afs.updateFarmer(farmer, value, password), HttpStatus.CREATED);
	}

	// total acres details
	@GetMapping("getTotalFarmedAndUmfarmedAcres")
	public String getAcresDetails() {
		return afs.farmedAndUnfarmedLands();
	}

//	Get Acres in percentage
	@GetMapping("getAcresInPercetage")
	public String getAcresInPercetage()
	{
		return afs.farmedAndUnfarmedLandsInPercentage();
	}
	
//	Get Acres in percentage
	@GetMapping("getCropsAndFarmAcresInPercetage")
	public String getCropsAndFarmAcresInPercetage()
	{
		return afs.totalAcresFarmedInPercentageWithSingeleItem();
	}
}
