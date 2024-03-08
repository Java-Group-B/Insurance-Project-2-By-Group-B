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
		
		  if(claim.getClaimType()==null) { throw new
		  IncompleteDetailsFilledException("ClaimType should not be blank. Please Enter valid ClaimType"
		  );
		  
		  } if(claim.getClaimCause()==null) { throw new
		  IncompleteDetailsFilledException("ClaimType should not be blank. Please Enter valid ClaimType"
		  );
		  
		  } if(claim.getClaimAmount()==null) { throw new
		  IncompleteDetailsFilledException("ClaimAmount should not be blank. Please Enter valid ClaimAmount"
		  );
		  
		  } if(claim.getClaimAmount()<0) { throw new
		  IncompleteDetailsFilledException("ClaimAmount should not be Negative. Please Enter valid ClaimAmount"
		  );
		  
		  }
		 
		Claim claim2 = claimRepository.save(claim);
		return claim2;
	}

}
