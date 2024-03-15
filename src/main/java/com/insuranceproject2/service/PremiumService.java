package com.insuranceproject2.service;

import com.insuranceproject2.model.PolicyPremium808;
import com.insuranceproject2.model.Premium;

public interface PremiumService {
	public Premium savePremium(Premium premium);
	
	public PolicyPremium808 setSavePremiumPolicy(PolicyPremium808 policyPremium808);
	public PolicyPremium808 getPolicyPremiumDetails(Integer userId);
}
