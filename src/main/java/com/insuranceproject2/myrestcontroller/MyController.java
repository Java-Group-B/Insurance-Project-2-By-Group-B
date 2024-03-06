package com.insuranceproject2.myrestcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {

	@GetMapping("/getMessage")
	public String getMessage() {
		return "Welcome to Insurance Project-2 By Group B";
	}
}
