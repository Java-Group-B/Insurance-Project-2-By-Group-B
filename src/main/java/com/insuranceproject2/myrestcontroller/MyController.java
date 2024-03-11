package com.insuranceproject2.myrestcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Claim;
import com.insuranceproject2.model.Driver;
import com.insuranceproject2.model.User;
import com.insuranceproject2.service.ClaimService;
import com.insuranceproject2.service.DriverService;
import com.insuranceproject2.service.UserService;

@RestController

public class MyController {

	@GetMapping("/getMessage")
	public String getMessage() {
		return "Welcome to Insurance Project-2 By Group B";
	}

	@Autowired
	private UserService userService;
	@Autowired
	private ClaimService claimService;
	@Autowired
	private DriverService driverService;


	@PostMapping("/saveUserClaim")
	@Transactional
	public User saveUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		List<Claim> claims = user.getClaimList();

		if (claims.isEmpty()) {

			throw new IncompleteDetailsFilledException(
					"Claim should not be blank. Please enter at least one Claim request");
		}

		for (Claim claim : claims) {
			claim.setUserId(user.getId());
			claimService.saveClaim(claim);
		}
		return user1;
	}
	@GetMapping("/getUserWithClaimById/{id}")
	public User getUserWithClaimById(@PathVariable("id") Integer id) {
		User user2=userService.getUserWithClaimById(id);
		
		return user2;
	}
	
	////
	// 1 all drivers
		@GetMapping("/Driver")
		public List<Driver> getAllDrivers() {
			return driverService.getAllDrivers();
		}

		// 2 drivers by id
		@GetMapping("/getDrivers/{Id}")
		public Driver getDrivers(@PathVariable("Id") int Id) {
			Driver driver = driverService.getDriverById(Id);    // remaining >>no of lines are more so optimize it
			return driver;
		}

		// 3 creating post mapping>> save
		@PostMapping("/saveDrivers")
		public Driver saveDrivers(@RequestBody Driver driver) {
		System.out.println("ABCD"+driver);
			Driver driver2 = driverService.saveDrivers(driver);
System.out.println("pqr"+driver2);
			return driver2;
		}

		// 4 creating put mapping >>> updates
		@PutMapping("/updateDriverById")
		public Driver updateDriverById(@RequestBody Driver driver) {
			Driver driver5 = driverService.updateDriverById(driver);
			return driver5;
		}
		
		// 5 creating a delete mapping >> delete
		@DeleteMapping("/deleteDrivers/{Id}")
		public void deleteDrivers(@PathVariable("Id") int Id) {
			driverService.deleteDriver(Id);
		}
	

}
