package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.Premium;
import com.insuranceproject2.repository.PremiumRepository;
import com.insuranceproject2.service.PremiumService;

@Service
public class PremiumServiceImpl implements PremiumService {
	@Autowired
	private PremiumRepository premiumRepository;

	@Override
	public Premium savePremium(Premium premium) {
		if (premium.getPremiumId() == null && premium.getPremiumPlanName() == null && premium.getPremiumType() == null
				&& premium.getPremiumAmount() == 0) {
			throw new IncompleteDetailsFilledException(
					"premium details are not present. please Enter the details first");
		} else if (premium.getPremiumId() == null) {
			throw new IncompleteDetailsFilledException("premium id is mandetory");
		} else if (premium.getPremiumPlanName() == null) {
			throw new IncompleteDetailsFilledException("premium plan name is mandetory");
		} else if (premium.getPremiumAmount() == 0) {
			throw new IncompleteDetailsFilledException("premium amount is mandetory");
		} else if (premium.getPremiumType() == null) {
			throw new IncompleteDetailsFilledException("premium type is mandetory");
		}

		else {
			return premiumRepository.save(premium);
		}
	}
}
