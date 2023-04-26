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

import com.agriculture.module.Crops;
import com.agriculture.service.CropsService;

@RestController
public class CropsController {

	@Autowired
	CropsService cs;

	@GetMapping("getTatalAcreBanana")
	public String getTatalAcreBanana() {
		return cs.getTotalAcreBanana();
	}

	@GetMapping("getTatalAcreCotton")
	public String getTatalAcreCotton() {
		return cs.getTotalAcreCotton();
	}

	@GetMapping("getTatalAcreMaize")
	public String getTatalAcreMaize() {
		return cs.getTotalAcreMaize();
	}

	@GetMapping("getTatalAcrePotato")
	public String getTatalAcrePotao() {
		return cs.getTotalAcrePotato();
	}

	@GetMapping("getTatalAcreRagi")
	public String getTatalAcreRagi() {
		return cs.getTotalAcreRagi();
	}

	@GetMapping("getTatalAcreRice")
	public String getTatalAcreRice() {
		return cs.getTotalAcreRice();
	}

	@GetMapping("getTatalAcreSugarcane")
	public String getTatalAcreSugarcane() {
		return cs.getTotalAcreSugarcane();
	}

	@GetMapping("getTatalAcreWheat")
	public String getTatalAcreWheat() {
		return cs.getTotalAcreWheat();
	}

	@GetMapping("getTotalAcreBananaByFarmerData")
	public String getTotalAcreBananaByValue(@RequestHeader String value) {
		return cs.getTotalBananaByData(value);
	}

	@GetMapping("getTotalAcreCottonByFarmerData")
	public String getTotalAcreCottonByValue(@RequestHeader String value) {
		return cs.getTotalCottonByData(value);
	}

	@GetMapping("getTotalAcreMaizeByFarmerData")
	public String getTotalAcreMaizeByValue(@RequestHeader String value) {
		return cs.getTotalMaizeByData(value);
	}

	@GetMapping("getTotalAcrePotatoByFarmerData")
	public String getTotalAcrePotatoByValue(@RequestHeader String value) {
		return cs.getTotalPotatoByData(value);
	}

	@GetMapping("getTotalAcreRagiByFarmerData")
	public String getTotalAcreRagiByValue(@RequestHeader String value) {
		return cs.getTotalRagiByData(value);
	}

	@GetMapping("getTotalAcreRiceByFarmerData")
	public String getTotalAcreRiceByValue(@RequestHeader String value) {
		return cs.getTotalRiceByData(value);
	}

	@GetMapping("getTotalAcreSugarcaneByFarmerData")
	public String getTotalAcreSugarcaneByValue(@RequestHeader String value) {
		return cs.getTotalSugarCaneByData(value);
	}

	@GetMapping("getTotalAcreWheatByFarmerData")
	public String getTotalAcreWheatByValue(@RequestHeader String value) {
		return cs.getTotalWheatByData(value);
	}

//	update the crops data
	@PutMapping("updateCropsByIdProof/{idproof}/{password}")
	public ResponseEntity<Object> updateCropsByIDproof(@PathVariable("idproof") String idproof,
			@PathVariable("password") String password, @RequestBody Crops crops) {

		return new ResponseEntity<Object>(cs.updateCrops(idproof, password, crops), HttpStatus.CREATED);
	}
	
//	total Acres of crops
	@GetMapping("totalAcresOfCrops")
	public String totalAcresOfCrops()
	{
		return cs.totalAcresOfCrops();
	}

}
