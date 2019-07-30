package com.rohan.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	
	//Shows custom-login form
	@GetMapping("/loginPage")
	public String showLoginPage() {
		return "custom-login";
	}
	
	
}
