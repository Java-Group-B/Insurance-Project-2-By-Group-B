package com.insuranceproject2.myrestcontroller;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.insuranceproject2.service.PolicyService;
import com.insuranceproject2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/policyswagger")
@Tag(name = "Policy With Premium",description = "Details of policies for each user registered can be accessed")
public class PolicyController {

	@Autowired
	private UserService userService;
	
	@Operation(summary="Get the Policy and Premium Details",description="provides all details of policy and premium passed for user")
	@ApiResponse(responseCode = "200", description = "Successful GET command")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Entity Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")         
	
	@GetMapping("/getUserPolicyWithPremiumDetails/{userId}")
	public LinkedHashMap getUserPolicyWithPremiumDetails(@PathVariable("userId") Integer userId) {
		LinkedHashMap user1 = userService.getUserPolicyWithPremiumById(userId);
		return user1;
	}
}
