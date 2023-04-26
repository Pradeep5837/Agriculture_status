package com.agriculture.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriculture.exceptions.ResourceNotFoundException;
import com.agriculture.module.Crops;
import com.agriculture.module.Farm;
import com.agriculture.module.Farmer;
import com.agriculture.repo.CropsRepo;
import com.agriculture.repo.FarmRepo;
import com.agriculture.repo.FarmerRepo;
import com.agriculture.service.FarmerService;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	CropsRepo cr;
	@Autowired
	FarmerRepo fr;
	@Autowired
	FarmRepo farmRepo;

	@Override
	public Farmer saveData(Farmer farmer) {

		Crops crops = farmer.getCrops();
		crops.setRdNum(farmer.getRdNumber());
		farmer.setCrops(crops);

		Farm farm = farmer.getFarm();
		farm.setRdnumb(farmer.getRdNumber());
		farmer.setFarm(farm);
		farmer = fr.save(farmer);
		return farmer;
	}

	@Override
	public List<Farmer> getAllFarmer() {

		List<Farmer> farmerList = fr.findAll();
		return farmerList;
	}

	@Override
	public Object getFarmerByData(String value) {

		Farmer farmer = fr.getFarmerByData(value);
		if (farmer instanceof Farmer) {
			return farmer;
		} else {
			try {
				throw new ResourceNotFoundException("Farmer", "id proof added on data", value);

			} catch (Exception e) {
				return e.getMessage();
			}
		}

	}

	@Override
	public Farmer getById(int id) {

		return fr.getById(0);
	}

	@Override
	public Object updateFarmer(Farmer farmer, String idproof, String password) {

		Farmer f1 = fr.getFarmerByPassword(idproof, password);
		if (f1 instanceof Farmer) {
			if (farmer.getAadharNumber() > 0) {
				f1.setAadharNumber(farmer.getAadharNumber());
			}
			if (farmer.getAge() > 0) {
				f1.setAge(farmer.getAge());
			}
			if (farmer.getDistrict() != null)
				f1.setDistrict(farmer.getDistrict());
			if (farmer.getName() != null)
				f1.setName(farmer.getName());
			if (farmer.getPassword() != null)
				f1.setPassword(farmer.getPassword());
			if (farmer.getPhoneNumber() > 0)
				f1.setPhoneNumber(farmer.getPhoneNumber());
			if (farmer.getRdNumber() != null)
				f1.setRdNumber(farmer.getRdNumber());
			if (farmer.getState() != null)
				f1.setState(farmer.getState());
			if (farmer.getVillage() != null)
				f1.setVillage(farmer.getVillage());
			if (farmer.getAcres() > 0) {

				if (f1.getAcres() > farmer.getAcres()) {
					Crops crops = cr.getCropsByRDnumber(f1.getRdNumber());
					crops.setBanana(0.0);
					crops.setCotton(0.0);
					crops.setMaize(0.0);
					crops.setPotato(0.0);
					crops.setRagi(0.0);
					crops.setRice(0.0);
					crops.setWheat(0.0);
					crops.setSugarcane(0.0);
					cr.save(crops);

					Farm farm = farmRepo.getInstanceOfFarm(f1.getRdNumber());
					farm.setChicken(0.0);
					farm.setFish(0);
					farm.setGote(0);
					farm.setPig(0);
					farm.setSheep(0);
					farmRepo.save(farm);
				}
				f1.setAcres(farmer.getAcres());
			}
			fr.save(f1);
			return f1;
		} else {
			try {
				throw new ResourceNotFoundException("Farmer", "idproof or password", idproof);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	// to get total Acres used

	@Override
	public String farmedAndUnfarmedLands() {

		double totalAcres = fr.getTotalAcres();
		float banana = cr.getTotalAcreBanana();
		float cotton = cr.getTotalAcreCotton();
		float maize = cr.getTotalAcreMaize();
		float potato = cr.getTotalAcrePotato();
		float ragi = cr.getTotalAcreRagi();
		float rice = cr.getTotalAcreRice();
		float sugarcane = cr.getTotalAcreSugarcane();
		float wheat = cr.getTotalAcreWheat();

		float chicken = farmRepo.getTotalAcreChickenFarm();
		float fish = farmRepo.getTotalAcreFishFarm();
		float gote = farmRepo.getTotalAcreGoteFarm();
		float pig = farmRepo.getTotalAcrePigFarm();
		float sheep = farmRepo.getTotalAcreSheepFarm();

		double sumOfCropsAcres = banana + cotton + maize + potato + ragi + rice + sugarcane + wheat;
		double sumOfFarmAcres = chicken + fish + gote + pig + sheep;
		
		String result = "Aotal acres : " + totalAcres + "\nTotal Crops Acres : " + sumOfCropsAcres
				+ "\nTotal Farm acres : " + sumOfFarmAcres + "\nfarmed Acres : " + (sumOfCropsAcres + sumOfFarmAcres)
				+ "\nUnfarmed acres : " + (totalAcres - sumOfCropsAcres - sumOfFarmAcres);
		return result;
	}

	@Override
	public String farmedAndUnfarmedLandsInPercentage() {
		double totalAcres = fr.getTotalAcres();

		float banana = cr.getTotalAcreBanana();
		float cotton = cr.getTotalAcreCotton();
		float maize = cr.getTotalAcreMaize();
		float potato = cr.getTotalAcrePotato();
		float ragi = cr.getTotalAcreRagi();
		float rice = cr.getTotalAcreRice();
		float sugarcane = cr.getTotalAcreSugarcane();
		float wheat = cr.getTotalAcreWheat();

		float chicken = farmRepo.getTotalAcreChickenFarm();
		float fish = farmRepo.getTotalAcreFishFarm();
		float gote = farmRepo.getTotalAcreGoteFarm();
		float pig = farmRepo.getTotalAcrePigFarm();
		float sheep = farmRepo.getTotalAcreSheepFarm();

		double sumOfCropsAcres = banana + cotton + maize + potato + ragi + rice + sugarcane + wheat;
		double sumOfFarmAcres = chicken + fish + gote + pig + sheep;
		
		String result = "Total acres : " + (totalAcres) + "\nTotal Crops Acres : "
				+ ((sumOfCropsAcres / totalAcres) * 100) + "%" + "\nTotal Farm acres : "
				+ ((sumOfFarmAcres / totalAcres) * 100) + "%\nfarmed Acres : "
				+ ((sumOfCropsAcres + sumOfFarmAcres) / totalAcres) * 100 + "%\nUnfarmed acres : "
				+ ((totalAcres - sumOfCropsAcres - sumOfFarmAcres) / totalAcres) * 100 + "%";

		return result;
	}

	@Override
	public String totalAcresFarmedInPercentageWithSingeleItem() {

		double totalAcres = fr.getTotalAcres();
		float banana = cr.getTotalAcreBanana();
		float cotton = cr.getTotalAcreCotton();
		float maize = cr.getTotalAcreMaize();
		float potato = cr.getTotalAcrePotato();
		float ragi = cr.getTotalAcreRagi();
		float rice = cr.getTotalAcreRice();
		float sugarcane = cr.getTotalAcreSugarcane();
		float wheat = cr.getTotalAcreWheat();

		float chicken = farmRepo.getTotalAcreChickenFarm();
		float fish = farmRepo.getTotalAcreFishFarm();
		float gote = farmRepo.getTotalAcreGoteFarm();
		float pig = farmRepo.getTotalAcrePigFarm();
		float sheep = farmRepo.getTotalAcreSheepFarm();

		double sumOfCropsAcres = banana + cotton + maize + potato + ragi + rice + sugarcane + wheat;
		double sumOfFarmAcres = chicken + fish + gote + pig + sheep;
		String result = "%\nfarmed Acres : " + ((sumOfCropsAcres + sumOfFarmAcres) / totalAcres) * 100
				+ "%\nUnfarmed acres : " + ((totalAcres - sumOfCropsAcres - sumOfFarmAcres) / totalAcres) * 100 + "%"
				+ "\nTotal Crops Acres in Database : "
				+ ((sumOfCropsAcres / totalAcres) * 100) + "%"
				+ "\nTotal  Crops Acres :" + (sumOfCropsAcres) + "\nBanana : "
				+ (banana / sumOfCropsAcres) * 100 + "%\nCotton : "
				+ (cotton / sumOfCropsAcres) * 100 + "%\nMaize : "
				+ (maize / sumOfCropsAcres) * 100 + "%\nPotato : "
				+ (potato / sumOfCropsAcres) * 100 + "%\nRagi : "
				+ (ragi / sumOfCropsAcres) * 100 + "%\nRice : "
				+ (rice / sumOfCropsAcres) * 100 + "%\nSugarcane : "
				+ (sugarcane / sumOfCropsAcres) * 100 + "%\nWheat : "
				+ (wheat / sumOfCropsAcres) * 100 + "%\nTotal Farm acres : "
				+ ((sumOfFarmAcres / totalAcres) * 100) + "%\nTotal farm Acres : " 
				+ (sumOfFarmAcres) + "\nChicken : "
				+ (chicken / sumOfFarmAcres) * 100 + "%\nFish : "
				+ (fish / sumOfFarmAcres) * 100 + "%\nGote : "
				+ (gote / sumOfFarmAcres) * 100 + "%\nPig : "
				+ (pig / sumOfFarmAcres) * 100 + "\nSheep : "
				+ (sheep / sumOfFarmAcres) * 100 + "%";

		return result;
	}

}
