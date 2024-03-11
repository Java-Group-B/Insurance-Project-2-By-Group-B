package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.model.Policy807;
import com.insuranceproject2.model.Policy808;
import com.insuranceproject2.model.PolicyPremium808;
import com.insuranceproject2.repository.PolicyRepository807;
import com.insuranceproject2.repository.PolicyRepository808;
import com.insuranceproject2.repository.PremiumRepository808;
import com.insuranceproject2.service.PolicyService;
@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository807 policyRepository807;
	
	@Override
	public Policy807 savePolicy807(Policy807 policy807) {
	 Policy807 policy1 =policyRepository807.save(policy807);
		return policy1;
	}

	
	@Autowired
	private PolicyRepository808 policyRepository808;
	
	
	@Override
	public Policy808 setSavePolicy(Policy808 policy808) {
		Policy808 policy1 = policyRepository808.save(policy808);
			return policy1;		
		}

	@Override
	public Policy808 getUserPolicyDetails(Integer policyNo) {
		Policy808 policy808=policyRepository808.findById(policyNo).get();
			return policy808;
	}	

}
