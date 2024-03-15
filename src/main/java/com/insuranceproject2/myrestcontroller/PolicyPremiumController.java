package com.insuranceproject2.myrestcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceproject2.model.PolicyPremium808;
import com.insuranceproject2.service.PremiumService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Policy Premium Controller",description = "Details of Plans for every policy registred for user can be accessed")
public class PolicyPremiumController {

	@Autowired
	private PremiumService premiumService;
	
	@GetMapping("/getUserPremiumDetails/{premiumId}")
	@Operation(summary="Get the Policy Premium",description="provides all plans passed for user")
	@ApiResponse(responseCode = "200", description = "Successful GET command")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Entity Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")         
	public PolicyPremium808 getUserPremiumDetails(@PathVariable("premiumId") Integer premiumId) {
		PolicyPremium808 policyPremium808 = premiumService.getPolicyPremiumDetails(premiumId);
		return policyPremium808;
	}
}
