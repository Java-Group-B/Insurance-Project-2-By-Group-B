package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.model.Policy807;
import com.insuranceproject2.repository.PolicyRepository;
import com.insuranceproject2.service.PolicyService;
@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	
	@Override
	public Policy807 savePolicy807(Policy807 policy807) {
	 Policy807 policy1 =policyRepository.save(policy807);
		return policy1;
	}

}
