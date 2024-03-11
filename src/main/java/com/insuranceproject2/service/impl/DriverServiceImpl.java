package com.insuranceproject2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.model.Driver;
import com.insuranceproject2.repository.DriverRepository;
import com.insuranceproject2.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverRepository driverRepository;

	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> driver = new ArrayList<Driver>();
		driver.addAll(driverRepository.findAll()); // another way
		return driver;
	}

	@Override
	public Driver getDriverById(int Id) {
		Driver driver3 = driverRepository.findById(Id).get();
		return driver3;
	}

	

	@Override
	public Driver updateDriverById(Driver driver) {
		Driver driver5 = driverRepository.save( driver);
		return driver5;
	}

	@Override
	public void deleteDriver(int id) {
		
			driverRepository.deleteById(id);
		
	}

	@Override
	public Driver saveDrivers(Driver driver) {
		System.out.println("xyz"+driver);
		Driver driver4 = driverRepository.save(driver);
		System.out.println("spd"+driver4);
		return driver4;
		
	}

/*	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> driver = new ArrayList<Driver>();
		driver.addAll(driverRepository.findAll()); // another way
		return driver;
	}

//2getting  record >> method findById()
	public Driver getDriverById(int Id) {
		Driver driver3 = driverRepository.findById(Id).get();
		return driver3;
	}

//3saving a record >> method save()   
	public Driver saveDrivers(Driver driver) {
		System.out.println("xyz"+driver);
		Driver driver4 = driverRepository.save(driver);
		System.out.println("spd"+driver4);
		return driver4;
	}

//4updating a record  
	public Driver updateDriverById(Driver driver) {
		Driver driver5 = driverRepository.save( driver);
		return driver5;
	}
	
//5 deleting  record >> method deleteById() 
	public void deleteDriver(int id) {
		driverRepository.deleteById(id);
	}*/
	

}
