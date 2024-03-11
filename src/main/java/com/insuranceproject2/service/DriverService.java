package com.insuranceproject2.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.insuranceproject2.model.Driver;

public interface DriverService {
	// 1>>all records
	public List<Driver> getAllDrivers();  
	 //2 >>getting  record >> method findById()
	public Driver getDriverById(int Id) ;
	
	//3>>saving a record >> method save()   
	//public Driver saveDrivers(Driver driver) ;
	public Driver saveDrivers(Driver driver);

	// 4>>updating a record  
	
	public Driver updateDriverById(Driver driver);
	
	//5>>deleting  record >> method deleteById() 
	public void deleteDriver(int id);
	
	
	
}  