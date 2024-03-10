package com.insuranceproject2.myrestcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Claim;
import com.insuranceproject2.model.User;
import com.insuranceproject2.service.ClaimService;
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
	
	

}
