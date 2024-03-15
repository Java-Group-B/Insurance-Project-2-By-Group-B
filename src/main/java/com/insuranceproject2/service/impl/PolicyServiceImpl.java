package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Policy;
import com.insuranceproject2.repository.PolicyRepository;
import com.insuranceproject2.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Policy savePolicy(Policy policy) {
		if (policy.getPolicyId() == null && policy.getPolicyName() == null && policy.getPolicyStatus() == null
				&& policy.getPolicyTerm() == 0) {
			throw new IncompleteDetailsFilledException(
					"Policy details are not present.\n please enter the detailsfirst");
		} else if (policy.getPolicyId() == null) {
			throw new IncompleteDetailsFilledException("policy id is mandetory");
		} else if (policy.getPolicyName() == null) {
			throw new IncompleteDetailsFilledException("policy name is mandetory");
		} else if (policy.getPolicyStatus() == null) {
			throw new IncompleteDetailsFilledException("policy status is mandetory");
		} else if (policy.getCoverageAmount() == 0.0) {
			throw new IncompleteDetailsFilledException("policy coverage amount is mandetory");
		} else if (policy.getPolicyTerm() == 0) {
			throw new IncompleteDetailsFilledException("policy term is mandetory");
		} else {
			return policyRepository.save(policy);
		}
	}

}
