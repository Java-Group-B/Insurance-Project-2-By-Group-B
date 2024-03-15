package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Claim;
import com.insuranceproject2.repository.ClaimRepository;
import com.insuranceproject2.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {
	@Autowired
	private ClaimRepository claimRepository;

	@Override
	public Claim saveClaim(Claim claim) {
		if ((claim.getClaimType() == null) && (claim.getClaimCause() == null) && (claim.getClaimAmount() == 0)) {
			throw new IncompleteDetailsFilledException(
					"ClaimDetails should not be blank. Please Enter valid Claim Details");
		}
		if (claim.getClaimType() == null) {
			throw new IncompleteDetailsFilledException("ClaimType should not be blank. Please Enter valid ClaimType");

		}
		if (claim.getClaimCause() == null) {
			throw new IncompleteDetailsFilledException("ClaimCause should not be blank. Please Enter valid ClaimCause");

		}
		if (claim.getClaimAmount() == 0) {
			throw new IncompleteDetailsFilledException(
					"ClaimAmount should not be blank. Please Enter valid ClaimAmount");
		}
		return claimRepository.save(claim);

	}
}
