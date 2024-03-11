package com.insuranceproject2.myrestcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceproject2.model.Policy808;
import com.insuranceproject2.service.PolicyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Policy Controller",description = "Details of policies for each user registered can be accessed")
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	@GetMapping("/getPolicyDetails/{policySerialNo}")
	@Operation(summary="Get the claim",description="provides all claims passed or user")
	@ApiResponse(responseCode = "200", description = "Successful GET command")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Entity Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")         
	public Policy808 getUserPolicyDetails(@PathVariable("policySerialNo") Integer policySerialNo) {
		Policy808 policy808 = policyService.getUserPolicyDetails(policySerialNo);
		return policy808;
	}
	
}
