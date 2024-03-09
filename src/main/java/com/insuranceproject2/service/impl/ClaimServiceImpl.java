package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		Claim claim2 = claimRepository.save(claim);
		return claim2;
	}

}
