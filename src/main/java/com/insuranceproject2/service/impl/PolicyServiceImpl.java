package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Policy;
import com.insuranceproject2.model.Policy807;
import com.insuranceproject2.model.Policy808;
import com.insuranceproject2.repository.PolicyRepository;
import com.insuranceproject2.repository.PolicyRepository807;
import com.insuranceproject2.repository.PolicyRepository808;
import com.insuranceproject2.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Policy savePolicy(Policy policy) {
		if (policy.getPolicyId() == null && policy.getPolicyName() == null
				&& policy.getPolicyStatus() == null && policy.getPolicyTerm() == 0) {
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
		}
		else {
		return policyRepository.save(policy);
	}
	}

	@Autowired
	private PolicyRepository807 policyRepository807;

	@Override
	public Policy807 savePolicy807(Policy807 policy807) {
		Policy807 policy1 = policyRepository807.save(policy807);
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
		Policy808 policy808 = policyRepository808.findById(policyNo).get();
		return policy808;
	}

}
