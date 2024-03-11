package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insuranceproject2.model.PolicyPremium808;
import com.insuranceproject2.repository.PremiumRepository808;
import com.insuranceproject2.service.PolicyPremiumService;


@Service
public class PolicyPremiumServiceImpl implements PolicyPremiumService{

	@Autowired
	private PremiumRepository808 premiumRepository808;

	@Override
	public PolicyPremium808 setSavePremiumPolicy(PolicyPremium808 policyPremium808) {

		PolicyPremium808 policyPremium1 = premiumRepository808.save(policyPremium808);
		return policyPremium1;
}

	@Override
	public PolicyPremium808 getPolicyPremiumDetails(Integer premiumId) {
		PolicyPremium808 policyPremium2=premiumRepository808.findById(premiumId).get();
		return policyPremium2;
	}
}
