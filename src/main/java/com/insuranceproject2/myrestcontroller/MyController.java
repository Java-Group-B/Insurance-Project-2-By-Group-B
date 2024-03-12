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
import com.insuranceproject2.model.Policy808;
import com.insuranceproject2.model.PolicyPremium808;
import com.insuranceproject2.model.User795;
import com.insuranceproject2.model.User802;
import com.insuranceproject2.model.User807;
import com.insuranceproject2.model.User808;
import com.insuranceproject2.service.ClaimService;
import com.insuranceproject2.service.DriverService;
import com.insuranceproject2.service.PolicyPremiumService;
import com.insuranceproject2.service.PolicyService;
import com.insuranceproject2.service.UserService;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
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
	private PolicyPremiumService policyPremiumService;

	@PostMapping("/saveUserClaim")
	@Transactional
	public User795 saveUser(@RequestBody User795 user) {
		User795 user1 = userService.saveUser(user);
		List<Claim795> list = user.getClaimList();
		for (Claim795 claim795 : list) {
			claim795.setUserId(user.getId());
			claimService.saveClaim(claim795);
		}
		return user1;
	}

	@GetMapping("/getUserWithClaimById/{id}")
	public User795 getUserWithClaimById(@PathVariable("id") Integer id) {
		User795 user2 = userService.getUserWithClaimById(id);

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
		Driver driver = driverService.getDriverById(Id); // remaining >>no of lines are more so optimize it
		return driver;
	}

	// 3 creating post mapping>> save
	@PostMapping("/saveDrivers")
	public Driver saveDrivers(@RequestBody Driver driver) {
		System.out.println("ABCD" + driver);
		Driver driver2 = driverService.saveDrivers(driver);
		System.out.println("pqr" + driver2);
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
		User807 user1 = userService.saveUser807(user807);
		List<Policy807> policyList = user807.getPolicyList();

		for (Policy807 policy807 : policyList) {

			policy807.setId(user807.getUserId());
			policyService.savePolicy807(policy807);

			Set<Claim807> claimSet = policy807.getClaimSet();
			for (Claim807 claimList : claimSet) {

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

	@PostMapping("/saveUserPolicyDetails")
	@Transactional
	public User808 saveUserPolicyDetails(@RequestBody User808 user808) {

		if (user808.getFirstName() == null && user808.getLastName() == null && user808.getEmail() == null) {
			throw new IncompleteDetailsFilledException(
					"User details are not present.\n please enter the details first");
		} else if (user808.getFirstName() == null) {
			throw new IncompleteDetailsFilledException(" First name is mandetory");
		} else if (user808.getLastName() == null) {
			throw new IncompleteDetailsFilledException(" last name is mandetory");
		} else if (user808.getEmail() == null) {
			throw new IncompleteDetailsFilledException(" email is mandetory");
		}
		User808 user1 = userService.setSaveUser(user808);

		List<Policy808> policy808s = user808.getPolicyList();
		for (Policy808 policy808 : policy808s) {
			if (policy808.getPolicyId() == null && policy808.getPolicyName() == null
					&& policy808.getPolicyStatus() == null && policy808.getPolicyTerm() == 0) {
				throw new IncompleteDetailsFilledException(
						"Policy details are not present.\n please enter the detailsfirst");
			} else if (policy808.getPolicyId() == null) {
				throw new IncompleteDetailsFilledException("policy id is mandetory");
			} else if (policy808.getPolicyName() == null) {
				throw new IncompleteDetailsFilledException("policy name is mandetory");
			} else if (policy808.getPolicyStatus() == null) {
				throw new IncompleteDetailsFilledException("policy status is mandetory");
			} else if (policy808.getCoverageAmount() == 0.0) {
				throw new IncompleteDetailsFilledException("policy coverage amount is mandetory");
			} else if (policy808.getPolicyTerm() == 0) {
				throw new IncompleteDetailsFilledException("policy term is mandetory");
			} else {
				policy808.setUserId(user808.getUserId());
				policyService.setSavePolicy(policy808);
			}

			List<PolicyPremium808> policyPremiumPlans = policy808.getPremiumPlans();

			for (PolicyPremium808 policyPremium808 : policyPremiumPlans) {

				if (policyPremium808.getPremiumId() == null && policyPremium808.getPremiumPlanName() == null
						&& policyPremium808.getPremiumType() == null && policyPremium808.getPremiumAmount() == 0) {
					throw new IncompleteDetailsFilledException(
							"premium details are not present.\n please enter the details first");
				} else if (policyPremium808.getPremiumId() == null) {
					throw new IncompleteDetailsFilledException("premium id is mandetory");
				} else if (policyPremium808.getPremiumPlanName() == null) {
					throw new IncompleteDetailsFilledException("premium plan name is mandetory");
				} else if (policyPremium808.getPremiumAmount() == 0) {
					throw new IncompleteDetailsFilledException("premium amount is mandetory");
				} else if (policyPremium808.getPremiumType() == null) {
					throw new IncompleteDetailsFilledException("premium type is mandetory");
				} else {
					policyPremium808.setPolicyNo(policy808.getPolicySerialNo());
					policyPremiumService.setSavePremiumPolicy(policyPremium808);
				}
			}
		}
		return user1;
	}

	@GetMapping("/getUserPolicyDetails/{userId}")
	public User808 getUserPolicyDetails(@PathVariable("userId") Integer userId) {
		User808 user1 = userService.getUserPolicyDetails(userId);
			return user1;
	}

	@PostMapping("/saveUser802")
	public User802 saveUser802(@RequestBody User802 user802) {
		return userService.saveUser802(user802);
	}

	@GetMapping("/findByUserFirstName/{firstName}")
	public List<User802> findByUserFirstName(@PathVariable("firstName") String firstName) {
		List<User802> user1 = userService.getUserByFirstName(firstName);
		return user1;
	}

	@GetMapping("/findByUserLastName/{lastName}")
	public List<User802> findByUserLastName(@PathVariable("lastName") String lastName) {
		List<User802> user2 = userService.getUserByLastName(lastName);
		return user2;
	}

	@GetMapping("/findByUserEmail/{email}")
	public List<User802> findByUserEmail(@PathVariable("email") String email) {
		List<User802> user3 = userService.getUserByEmail(email);
		return user3;
	}
}
