package com.insuranceproject2.service;

import com.insuranceproject2.model.Claim795;
import com.insuranceproject2.model.Claim798;
import com.insuranceproject2.model.Claim807;

public interface ClaimService {
	
	public Claim795 saveClaim(Claim795 claim795);
	public Claim807 saveClaim807(Claim807 claim807);
	
	public Claim798 getUserClaimDetails(Integer claimId);
	public Claim798 setSaveClaim(Claim798 claim798);
}
