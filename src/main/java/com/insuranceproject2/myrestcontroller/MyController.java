package com.insuranceproject2.myrestcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("/795saveUserClaim")
	@Transactional
	public User saveUser(@RequestBody User user) {
		if (user.getFirstName() == null && user.getLastName() == null && user.getEmailId() == null) {
			throw new IncompleteDetailsFilledException("Please Enter User Details");
		}
		if (user.getFirstName() == null || user.getFirstName() == "") {
			throw new IncompleteDetailsFilledException("FirstName cannot be blank.Please enter Firstname");

		}
		if (user.getLastName() == null || user.getLastName() == "") {
			throw new IncompleteDetailsFilledException("LastName cannot be blank.Please enter Lastname");
		}
		if (user.getEmailId() == null || user.getEmailId() == "") {
			throw new IncompleteDetailsFilledException("Email id cannot blank.Please Enter valid mail id.");
		}
		User user1 = userService.saveUser(user);
		List<Claim> claims = user.getClaimList();

		if (claims.isEmpty()) {
			throw new IncompleteDetailsFilledException(
					"Claim should not be blank. Please enter at least one Claim request");
		}

		for (Claim claim : claims) {

			if (claim.getClaimType() == null||claim.getClaimType() == "") {
				throw new IncompleteDetailsFilledException(
						"ClaimType should not be blank. Please Enter valid ClaimType");
			}
			if (claim.getClaimCause() == null||claim.getClaimCause() == "") {
				throw new IncompleteDetailsFilledException(
						"ClaimType should not be blank. Please Enter valid ClaimType");
			}
			if (claim.getClaimAmount() == null) {
				throw new IncompleteDetailsFilledException(
						"ClaimAmount should not be blank. Please Enter valid ClaimAmount");
			}
			if (claim.getClaimAmount() < 0) {
				throw new IncompleteDetailsFilledException(
						"ClaimAmount should not be Negative. Please Enter valid ClaimAmount");
			}

			claim.setUserId(user.getId());
			claimService.saveClaim(claim);
		}
		return user1;
	}

}
