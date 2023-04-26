package com.agriculture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriculture.exceptions.CustumException;
import com.agriculture.exceptions.ResourceNotFoundException;
import com.agriculture.module.Crops;
import com.agriculture.module.Farm;
import com.agriculture.repo.CropsRepo;
import com.agriculture.repo.FarmRepo;
import com.agriculture.repo.FarmerRepo;
import com.agriculture.service.CropsService;
import com.mysql.cj.protocol.Resultset;

@Service
public class CorpsServiceImpl implements CropsService {

	@Autowired
	CropsRepo cr;

	@Autowired
	FarmerRepo fr;

	@Autowired
	FarmRepo farmRepo;

	@Override
	public Crops saveData(Crops crops) {
		return cr.save(crops);
	}

	@Override
	public String getTotalAcreBanana() {

		String totalAcreBanana = cr.getTotalAcreBanana() + " acres";
		return totalAcreBanana;
	}

	@Override
	public String getTotalAcreCotton() {

		String totalAcreCotton = cr.getTotalAcreCotton() + " acres";
		return totalAcreCotton;
	}

	@Override
	public String getTotalAcreMaize() {

		String totalAcreMaize = cr.getTotalAcreMaize() + " acres";
		return totalAcreMaize;
	}

	@Override
	public String getTotalAcrePotato() {

		String totalAcrePotato = cr.getTotalAcrePotato() + " acres";
		return totalAcrePotato;
	}

	@Override
	public String getTotalAcreRagi() {

		String totalAcreRagi = cr.getTotalAcreRagi() + " acres";
		return totalAcreRagi;
	}

	@Override
	public String getTotalAcreRice() {

		String totalAcreRice = cr.getTotalAcreRice() + " acres";
		return totalAcreRice;
	}

	@Override
	public String getTotalAcreSugarcane() {

		String totalAcreSugarcane = cr.getTotalAcreSugarcane() + " acres";
		return totalAcreSugarcane;
	}

	@Override
	public String getTotalAcreWheat() {

		String totalAcreWheat = cr.getTotalAcreWheat() + " acres";
		return totalAcreWheat;
	}

	@Override
	public String getTotalBananaByData(String value) {

		String totalAcreBanana = cr.getTotalAcreBananaByData(value);
		if (totalAcreBanana != null) {
			return totalAcreBanana + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}

	}

	@Override
	public String getTotalCottonByData(String value) {

		String totalAcreCotton = cr.getTotalAcreCotton(value);
		if (totalAcreCotton != null) {
			return totalAcreCotton + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalMaizeByData(String value) {

		String totalAcreMaize = cr.getTotalAcreMaize(value);
		if (totalAcreMaize != null) {
			return totalAcreMaize + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalPotatoByData(String value) {

		String totalAcrePotato = cr.getTotalAcrePotato(value);
		if (totalAcrePotato != null) {
			return totalAcrePotato + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalRagiByData(String value) {

		String totalAcreRagi = cr.getTotalAcreRagi(value);
		if (totalAcreRagi != null) {
			return totalAcreRagi + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalRiceByData(String value) {

		String totalAcreRice = cr.getTotalAcreRice(value);
		if (totalAcreRice != null) {
			return totalAcreRice + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalSugarCaneByData(String value) {

		String totalAcreSugarcane = cr.getTotalAcreSugarcane(value);
		if (totalAcreSugarcane != null) {
			return totalAcreSugarcane + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	@Override
	public String getTotalWheatByData(String value) {

		String tatalAcreWheat = cr.getTotalAcreWheat(value);
		if (tatalAcreWheat != null) {
			return tatalAcreWheat + " acres";
		} else {
			try {

				throw new ResourceNotFoundException("crops", "idproof", value);
			} catch (Exception e) {

				return e.getMessage();
			}
		}
	}

	@Override
	public Object updateCrops(String idproof, String password, Crops crops) {

		Crops c1 = cr.getCropsInstance(idproof, password);
		Double acres = fr.totalAcresOfFarmer(c1.getRdNum());
		if (c1 instanceof Crops) {

			if (crops.getBanana() > 0)
				c1.setBanana(crops.getBanana());
			else if (crops.getBanana() < 0)
				c1.setBanana(0.0);
			if (crops.getCotton() > 0)
				c1.setCotton(crops.getCotton());
			else if (crops.getCotton() < 0)
				c1.setCotton(0.0);
			if (crops.getMaize() > 0)
				c1.setMaize(crops.getMaize());
			else if (crops.getMaize() < 0)
				c1.setMaize(0.0);
			if (crops.getPotato() > 0)
				c1.setPotato(crops.getPotato());
			else if (crops.getPotato() < 0)
				c1.setPotato(0.0);
			if (crops.getRagi() > 0)
				c1.setRagi(crops.getRagi());
			else if (crops.getRagi() < 0)
				c1.setRagi(0.0);
			if (crops.getRice() > 0)
				c1.setRice(crops.getRice());
			else if (crops.getRice() < 0)
				c1.setRice(0.0);
			if (crops.getSugarcane() > 0)
				c1.setSugarcane(crops.getSugarcane());
			else if (crops.getSugarcane() < 0)
				c1.setSugarcane(0.0);
			if (crops.getWheat() > 0)
				c1.setWheat(crops.getWheat());
			else if (crops.getWheat() < 0)
				c1.setWheat(0.0);

			double prsentAcres = (c1.getBanana() + c1.getCotton() + c1.getMaize() + c1.getPotato() + c1.getRagi()
					+ c1.getRice() + c1.getSugarcane() + c1.getWheat());

			Farm f = farmRepo.getInstanceOfFarm(c1.getRdNum());
			double TotalAcresOfFarm = f.getChicken() + f.getFish() + f.getGote() + f.getPig() + f.getSheep();

			if ((acres - TotalAcresOfFarm) >= prsentAcres) {
				cr.save(c1);
				return "Data saved\n" + c1;
			}

			else {
				try {
					throw new CustumException("Data not save \\nMismatching Acres");
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

	@Override
	public String totalAcresOfCrops() {

		double sumOfCropsAcre = cr.getTotalAcreBanana() + cr.getTotalAcreCotton() + cr.getTotalAcreMaize()
				+ cr.getTotalAcrePotato() + cr.getTotalAcreRagi() + cr.getTotalAcreRice() + cr.getTotalAcreSugarcane()
				+ cr.getTotalAcreWheat();
		return sumOfCropsAcre + " Acres of crops";
	}

}
