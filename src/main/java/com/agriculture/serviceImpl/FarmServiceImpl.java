package com.agriculture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriculture.exceptions.CustumException;
import com.agriculture.exceptions.ResourceNotFoundException;
import com.agriculture.module.Crops;
import com.agriculture.module.Farm;
import com.agriculture.module.Farmer;
import com.agriculture.repo.CropsRepo;
import com.agriculture.repo.FarmRepo;
import com.agriculture.repo.FarmerRepo;
import com.agriculture.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService {

	@Autowired
	FarmRepo fr;

	@Autowired
	FarmerRepo farmerReop;

	@Autowired
	CropsRepo cr;

	@Override
	public Farm saveData(Farm farm) {

		return fr.save(farm);
	}

	@Override
	public String getTotalAcreChickenFarm() {

		return fr.getTotalAcreChickenFarm() + " Acres";
	}

	@Override
	public String getTotalAcreSheepFarm() {

		return fr.getTotalAcreSheepFarm() + " Acres";
	}

	@Override
	public String getTotalAcreFishFarm() {

		return fr.getTotalAcreFishFarm() + " Acres";
	}

	@Override
	public String getTotalAcreGoteFarm() {

		return fr.getTotalAcreGoteFarm() + " Acres";
	}

	@Override
	public String getTotalAcrePigFarm() {

		return fr.getTotalAcrePigFarm() + " Acres";
	}

	@Override
	public String getTotalAcreChickenFarmByFarmerData(String value) {

		String acres = fr.getTotalAcreChickenFarmByData(value);
		if (acres != null)
			return acres + " Acres";
		else {
			try {
				throw new ResourceNotFoundException("Farm", "id proof or data", value);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalAcreSheepFarmByFarmerData(String value) {

		String acres = fr.getTotalAcreSheepFarmByData(value);
		if (acres != null)
			return acres + " Acres";
		else {
			try {
				throw new ResourceNotFoundException("Farm", "id proof or data", value);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalAcreFishFarmByFarmerData(String value) {

		String acres = fr.getTotalAcreFishFarmByData(value);
		if (acres != null)
			return acres + " Acres";
		else {
			try {
				throw new ResourceNotFoundException("Farm", "id proof or data", value);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalAcreGoteFarmByFarmerData(String value) {

		String acres = fr.getTotalAcreGoteFarmByData(value);
		if (acres != null)
			return acres + " Acres";
		else {
			try {
				throw new ResourceNotFoundException("Farm", "id proof or data", value);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalAcrePigFarmByFarmerData(String value) {

		String acres = fr.getTotalAcrePigFarmByData(value);
		if (acres != null)
			return acres + " Acres";
		else {
			try {
				throw new ResourceNotFoundException("Farm", "id proof or data", value);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}

	@Override
	public String totalAcresOfFarm() {

		double sumOfAcres = (fr.getTotalAcreChickenFarm() + fr.getTotalAcreFishFarm() + fr.getTotalAcreGoteFarm()
				+ fr.getTotalAcrePigFarm() + fr.getTotalAcreSheepFarm());
		return sumOfAcres + " Acres are Farms";
	}

	@Override
	public Object updateFarm(String idproof, String password, Farm farm) {

		Farmer farmer = farmerReop.getFarmerByPassword(idproof, password);
		Farm f = fr.getInstanceOfFarm(farmer.getRdNumber());
		if (farmer instanceof Farmer) {
			if (farm.getChicken() > 0)
				f.setChicken(farm.getChicken());
			else if (farm.getChicken() < 0)
				f.setChicken(0.0);
			if (farm.getFish() > 0)
				f.setFish(farm.getFish());
			else if (farm.getFish() < 0)
				f.setFish(0.0);
			if (farm.getGote() > 0)
				f.setGote(farm.getGote());
			else if (farm.getGote() < 0)
				f.setGote(0.0);
			if (farm.getPig() > 0)
				f.setPig(farm.getPig());
			else if (farm.getPig() < 0)
				f.setPig(0.0);
			if (farm.getSheep() > 0)
				f.setSheep(farm.getSheep());
			else if (farm.getSheep() < 0)
				f.setSheep(0.0);

			double presentAcresOfFarmer = farmerReop.totalAcresOfFarmer(farmer.getRdNumber());

			Crops c1 = cr.getCropsInstance(idproof, password);

			double prsentAcresOfCrops = (c1.getBanana() + c1.getCotton() + c1.getMaize() + c1.getPotato() + c1.getRagi()
					+ c1.getRice() + c1.getSugarcane() + c1.getWheat());

			double TotalAcresOfFarm = f.getChicken() + f.getFish() + f.getGote() + f.getPig() + f.getSheep();

			if ((presentAcresOfFarmer - prsentAcresOfCrops) >= TotalAcresOfFarm) {

				fr.save(f);
				return "Data saved\n" + f;
			} else {
				try {
					throw new CustumException("Data not save \nMismatching Acres");
				} catch (Exception e) {

					return e.getMessage();
				}
			}
		} else {
			try {
				throw new ResourceNotFoundException("Crops", "id proof or password", idproof);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

}
