package com.agriculture.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agriculture.module.Farmer;

public interface FarmerRepo extends JpaRepository<Farmer, Integer> {

	@Query(value = "SELECT * FROM Farmer where "
			+ " (Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ", nativeQuery = true)
	public Farmer getFarmerByData(String value);

	@Query(value = "SELECT * FROM Farmer where password=:password and"
			+ " (Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ", nativeQuery = true)
	public Farmer getFarmerByPassword(String value, String password);

	// get total Acres of farmer
	@Query(value = "select acres from Farmer where rd_number=:rd_number", nativeQuery = true)
	public Double totalAcresOfFarmer(String rd_number);

	// to get total Acres
	@Query(value = "select sum(acres) from Farmer", nativeQuery = true)
	public double getTotalAcres();
}
