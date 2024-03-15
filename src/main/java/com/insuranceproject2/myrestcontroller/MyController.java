package com.insuranceproject2.myrestcontroller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Claim;
import com.insuranceproject2.model.Driver;
import com.insuranceproject2.model.Policy;
import com.insuranceproject2.model.Premium;
import com.insuranceproject2.model.User;
import com.insuranceproject2.service.ClaimService;
import com.insuranceproject2.service.DriverService;
import com.insuranceproject2.service.PremiumService;
import com.insuranceproject2.service.PolicyService;
import com.insuranceproject2.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("/maincontroller")
@Hidden
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
	@Autowired
	private PremiumService premiumService;

	@PostMapping("/saveUser")
	@Transactional
	public User saveUser(@RequestBody User user) {
		User user2 = userService.saveUser(user);
		List<Policy> pList = user.getPolicylist();
		for (Policy p : pList) {
			p.setUserId(user.getId());
			Policy policy2 = policyService.savePolicy(p);
		}
		List<Premium> prList = user.getPremiunlist();
		for (Premium pr : prList) {
			pr.setUser_id(user.getId());
			Premium premium2 = premiumService.savePremium(pr);
		}
		List<Claim> cList = user.getClaimlist();
		for (Claim c : cList) {
			c.setUserId$(user.getId());
			Claim claim = claimService.saveClaim(c);
		}
		return user2;
	}

	@GetMapping("/getUserWithClaimById/{id}")
	public LinkedHashMap getUserWithClaimById(@PathVariable("id") Integer id) {
		LinkedHashMap user_Claim_Details = userService.getUserWithClaimById(id);
		return user_Claim_Details;
	}

	@GetMapping("/getUserPolicyWithPremiumDetails/{userId}")
	public LinkedHashMap getUserPolicyWithPremiumDetails(@PathVariable("userId") Integer userId) {
		LinkedHashMap user1 = userService.getUserPolicyWithPremiumById(userId);
		return user1;
	}

	@GetMapping("/getUserPolicyWithClaimById/{id}")
	public LinkedHashMap getUserPolicyWithClaimById(@PathVariable("id") Integer id) {
		LinkedHashMap user1 = userService.getUserPolicyWithClaimById(id);
		return user1;
	}

	@GetMapping("/findUserByFirstName/{firstName}")
	public List<User> findUserByFirstName(@PathVariable("firstName") String firstName) {
		List<User> user1 = userService.findUserByFirstName(firstName);
		return user1;
	}

	@GetMapping("/findUserByLastName/{lastName}")
	public List<User> findUserByLastName(@PathVariable("lastName") String lastName) {
		List<User> user2 = userService.findUserByLastName(lastName);
		return user2;
	}

	@GetMapping("/findUserByEmail/{emailId}")
	public List<User> findUserByEmail(@PathVariable("emailId") String emailId) {
		List<User> user3 = userService.findUserByEmail(emailId);
		return user3;
	}

	@GetMapping("/Driver")
	public List<Driver> getAllDrivers() {
		return driverService.getAllDrivers();
	}

	@GetMapping("/getDrivers/{Id}")
	public Driver getDrivers(@PathVariable("Id") int Id) {
		Driver driver = driverService.getDriverById(Id); 
		return driver;
	}

	@PostMapping("/saveDrivers")
	public Driver saveDrivers(@RequestBody Driver driver) {
		System.out.println("ABCD" + driver);
		Driver driver2 = driverService.saveDrivers(driver);
		System.out.println("pqr" + driver2);
		return driver2;
	}

	@PutMapping("/updateDriverById/{id}")
	public Driver updateDriverById(@RequestBody Driver driver, @PathVariable("id") Integer id) {
		Driver driver5 = driverService.updateDriverById(driver,id);
		return driver5;
	}

	@DeleteMapping("/deleteDrivers/{Id}")
	public void deleteDrivers(@PathVariable("Id") int Id) {
		driverService.deleteDriver(Id);
	}
	
}
