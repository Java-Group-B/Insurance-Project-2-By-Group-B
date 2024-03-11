package com.insuranceproject2.service;

import com.insuranceproject2.model.Policy807;
import com.insuranceproject2.model.Policy808;

public interface PolicyService {

	public Policy807 savePolicy807(Policy807 policy807);
	
	public Policy808 setSavePolicy(Policy808 policy808);
	public Policy808 getUserPolicyDetails(Integer premiumId);
}
