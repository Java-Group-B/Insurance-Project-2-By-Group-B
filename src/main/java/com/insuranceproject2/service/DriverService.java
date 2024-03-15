package com.insuranceproject2.service;

import java.util.List;
import com.insuranceproject2.model.Driver;

public interface DriverService {

	public List<Driver> getAllDrivers();

	public Driver getDriverById(int Id);

	public Driver saveDrivers(Driver driver);

	public Driver updateDriverById(Driver driver, Integer id);

	public void deleteDriver(int id);

}