package com.insuranceproject2.myrestcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceproject2.model.Claim798;
import com.insuranceproject2.service.ClaimService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Claim Controller",description = "Details of claims for every policy registred for user can be accessed")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	@GetMapping("/getUserClaim/{claimId}")
	@Operation(summary="Get the claim",description="provides all claims passed or user")
	@ApiResponse(responseCode = "200", description = "Successful GET command")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Entity Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")         
	public Claim798 getUserClaimDetails(@PathVariable("claimId") Integer claimId) {
		Claim798 claim1 = claimService.getUserClaimDetails(claimId);
		return claim1;
	}
	
}
