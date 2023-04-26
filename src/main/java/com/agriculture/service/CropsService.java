package com.agriculture.service;

import org.springframework.stereotype.Service;

import com.agriculture.module.Crops;

@Service
public interface CropsService {

	public Crops saveData(Crops crops);

	public String getTotalAcreBanana();

	public String getTotalAcreCotton();

	public String getTotalAcreMaize();

	public String getTotalAcrePotato();

	public String getTotalAcreRagi();

	public String getTotalAcreRice();

	public String getTotalAcreSugarcane();

	public String getTotalAcreWheat();

	public String getTotalBananaByData(String value);

	public String getTotalCottonByData(String value);

	public String getTotalMaizeByData(String value);

	public String getTotalPotatoByData(String value);

	public String getTotalRagiByData(String value);

	public String getTotalRiceByData(String value);

	public String getTotalSugarCaneByData(String value);

	public String getTotalWheatByData(String value);

	// update the data of crops
	public Object updateCrops(String idproof, String password, Crops crops);

//	get total Acres of crops cultivated 
	public String totalAcresOfCrops();
}