package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Claim795;
import com.insuranceproject2.model.Claim807;
import com.insuranceproject2.repository.ClaimRepository795;
import com.insuranceproject2.repository.ClaimRepository807;
import com.insuranceproject2.service.ClaimService;
@Service
public class ClaimServiceImpl implements ClaimService {
	@Autowired
	private ClaimRepository795 claimRepository795;

	@Autowired
	private ClaimRepository807 claimRepository807;
	
	@Override
	public Claim795 saveClaim(Claim795 claim795) {
		
		  if(claim795.getClaimType()==null) { throw new
		  IncompleteDetailsFilledException("ClaimType should not be blank. Please Enter valid ClaimType"
		  );
		  
		  } if(claim795.getClaimCause()==null) { throw new
		  IncompleteDetailsFilledException("ClaimType should not be blank. Please Enter valid ClaimType"
		  );
		  
		  } if(claim795.getClaimAmount()==null) { throw new
		  IncompleteDetailsFilledException("ClaimAmount should not be blank. Please Enter valid ClaimAmount"
		  );
		  
		  } if(claim795.getClaimAmount()<0) { throw new
		  IncompleteDetailsFilledException("ClaimAmount should not be Negative. Please Enter valid ClaimAmount"
		  );
		  
		  }
		 
		Claim795 claim2 = claimRepository795.save(claim795);
		return claim2;
	}
	
	
	@Override
	public Claim807 saveClaim807(Claim807 claim807) {
		Claim807 claim1 = claimRepository807.save(claim807);
		return claim1;
	}


}
