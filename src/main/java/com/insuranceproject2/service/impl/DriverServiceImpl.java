package com.insuranceproject2.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.exception.UserNotFoundException;
import com.insuranceproject2.model.Driver;
import com.insuranceproject2.model.User;
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
	public Driver getDriverById(int id) {

		Driver driver = this.driverRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Id is not present in Database."));

		return driver;
	}

	@Override
	public Driver saveDrivers(Driver driver) {

		if (driver.getName() == null && driver.getLicenseNo() == null && driver.getMobileNo() == null
				&& driver.getCity() == null) {
			throw new IncompleteDetailsFilledException("Driver Details cannot be blank.Please Enter Driver Details");

		} else if (driver.getName() == null) {

			throw new IncompleteDetailsFilledException("Driver Name cannot be blank. Please Enter Driver Name");
		} else if (driver.getLicenseNo() == null) {

			throw new IncompleteDetailsFilledException(
					"Driver LicenseNo cannot be blank. Please Enter Driver LicenseNo");
		} else if (driver.getMobileNo() == null) {

			throw new IncompleteDetailsFilledException("Driver MobileNo cannot be blank. Please Enter Driver MobileNo");
		} else if (driver.getCity() == null) {

			throw new IncompleteDetailsFilledException("Driver City cannot be blank. Please Enter Driver City");
		}

		Driver driver4 = driverRepository.save(driver);
		return driver4;
	}

	@Override
	public Driver updateDriverById(Driver driver, Integer id) {
		Driver driver2 = this.driverRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Id is not present in Database."));
		Driver driver5 = driverRepository.save(driver);
		return driver5;
	}

	@Override
	public void deleteDriver(int id) {

		driverRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Id is not present in Database."));

	}
}