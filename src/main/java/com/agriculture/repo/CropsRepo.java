package com.agriculture.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agriculture.module.Crops;
import com.agriculture.module.Farm;
import com.agriculture.module.Farmer;

public interface CropsRepo extends JpaRepository<Crops,Integer> {


	@Query(value="select sum(banana) from Crops",nativeQuery = true)
	public float getTotalAcreBanana();
	
	@Query(value="select banana from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcreBananaByData(String value);
	
	@Query(value="select sum(cotton) from Crops",nativeQuery = true)
	public float getTotalAcreCotton();
	
	@Query(value="select cotton from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcreCotton(String value);

	@Query(value="select sum(maize) from Crops",nativeQuery = true)
	public float getTotalAcreMaize();
	 
	@Query(value="select maize from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcreMaize(String value);
	
	@Query(value="select sum(potato) from Crops",nativeQuery = true)
	public float getTotalAcrePotato();
	
	@Query(value="select potato from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcrePotato(String value);

	@Query(value="select sum(ragi) from Crops",nativeQuery = true)
	public float getTotalAcreRagi();
	
	@Query(value="select rice from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcreRagi(String value);
	
	@Query(value="select sum(maize) from Crops",nativeQuery = true)
	public float getTotalAcreRice();
	
	@Query(value="select rice from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcreRice(String value);
	
	@Query(value="select sum(sugarcane) from Crops",nativeQuery = true)
	public float getTotalAcreSugarcane();
	
	@Query(value="select sugarcane from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcreSugarcane(String value);
	
	@Query(value="select sum(wheat) from Crops",nativeQuery = true)
	public float getTotalAcreWheat();
	
	@Query(value="select wheat from Crops,Farmer where Crops.rd_num=Farmer.rd_number and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public String getTotalAcreWheat(String value);
	
	@Query(value="select Crops.* from Crops,Farmer where Crops.rd_num=Farmer.rd_number and Farmer.password=:password and"
			+ "(Farmer.rd_number=:value or aadhar_number=:value or phone_number=:value) ",nativeQuery = true)
	public Crops getCropsInstance(String value,String password);

//	get crops data by rd-number
	@Query(value="select * from Crops where rd_num=:rdnumber",nativeQuery = true)
	public Crops getCropsByRDnumber(String rdnumber);

}
