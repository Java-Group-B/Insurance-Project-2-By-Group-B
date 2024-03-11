package com.insuranceproject2.myrestcontroller;

import java.util.List;
import java.util.Set;

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
import com.insuranceproject2.model.Claim795;
import com.insuranceproject2.model.Claim807;
import com.insuranceproject2.model.Driver;
import com.insuranceproject2.model.Policy807;
import com.insuranceproject2.model.User795;
import com.insuranceproject2.model.User807;
import com.insuranceproject2.service.ClaimService;
import com.insuranceproject2.service.DriverService;
import com.insuranceproject2.service.PolicyService;
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
	@Autowired
	private PolicyService policyService;
	
	@PostMapping("/saveUserClaim")
	@Transactional
	public User795 saveUser(@RequestBody User795 user) {
		System.out.println("abs "+user);
		User795 user1 = userService.saveUser(user);
		List<Claim795> list = user.getClaimList();

		if (list.isEmpty()) {

			throw new IncompleteDetailsFilledException(
					"Claim should not be blank. Please enter at least one Claim request");
		}

		for (Claim795 claim795 : list) {
			claim795.setUserId(user.getId());
			claimService.saveClaim(claim795);
		}
		return user1;
	}
	@GetMapping("/getUserWithClaimById/{id}")
	public User795 getUserWithClaimById(@PathVariable("id") Integer id) {
		User795 user2=userService.getUserWithClaimById(id);
		
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
	
		
		
		@PostMapping("/saveUser")
		public User807 saveUser(@RequestBody User807 user807) {
			System.out.println("Hi......"+user807);
			User807 user1 = userService.saveUser807(user807);
			System.out.println("Hi......807"+user1);
			List<Policy807> policyList =user807.getPolicyList();
			System.out.println("Sarika......asvdasvdhas"+policyList);
			for(Policy807 policy807: policyList) {

				policy807.setId(user807.getUserId());
				System.out.println("jhbsjfjsadha"+policy807);
				policyService.savePolicy807(policy807);
				
				Set<Claim807> claimSet = policy807.getClaimSet();
				for(Claim807 claimList: claimSet) {
					
					claimList.setPolicyNo(policy807.getPolicySerialNo());
					claimService.saveClaim807(claimList);
				}
			}
			return user1;
		}
		
		@GetMapping("/getUser/{id}")
		public User807 getUser(@PathVariable("id") Integer id) {
			User807 user1 = userService.getUser807(id);
			return user1;
		} 

}
