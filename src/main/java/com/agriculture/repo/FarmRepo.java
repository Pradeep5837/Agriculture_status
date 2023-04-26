package com.agriculture.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agriculture.module.Farm;

public interface FarmRepo extends JpaRepository<Farm, Integer> {

	// getting total Acre of Farms

	@Query(value = "select sum(chicken) from Farm", nativeQuery = true)
	public float getTotalAcreChickenFarm();

	@Query(value = "select sum(sheep) from Farm", nativeQuery = true)
	public float getTotalAcreSheepFarm();

	@Query(value = "select sum(fish) from Farm", nativeQuery = true)
	public float getTotalAcreFishFarm();

	@Query(value = "select sum(gote) from Farm", nativeQuery = true)
	public float getTotalAcreGoteFarm();

	@Query(value = "select sum(pig) from Farm", nativeQuery = true)
	public float getTotalAcrePigFarm();

	// get data by the id proof or data entered in database

	@Query(value = "select chicken from Farm,Farmer where Farm.rdnumb=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ", nativeQuery = true)
	public String getTotalAcreChickenFarmByData(String value);

	@Query(value = "select sheep from Farm,Farmer where Farm.rdnumb=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ", nativeQuery = true)
	public String getTotalAcreSheepFarmByData(String value);

	@Query(value = "select fish from Farm,Farmer where Farm.rdnumb=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ", nativeQuery = true)
	public String getTotalAcreFishFarmByData(String value);

	@Query(value = "select gote from Farm,Farmer where Farm.rdnumb=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ", nativeQuery = true)
	public String getTotalAcreGoteFarmByData(String value);

	@Query(value = "select pig from Farm,Farmer where Farm.rdnumb=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ", nativeQuery = true)
	public String getTotalAcrePigFarmByData(String value);

	
//	to get Farm instance
	@Query(value="select * from Farm where rdnumb=:rdnumber",nativeQuery=true)
	public Farm getInstanceOfFarm(String rdnumber);
	
}
