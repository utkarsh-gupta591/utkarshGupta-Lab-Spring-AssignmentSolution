package com.greatlearning.collegefest.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@GetMapping("/user")
	public @ResponseBody String getLoggedInUser(Principal principal) {
		return principal.getName();
	}

	@GetMapping("/")
	public String getHomePage() {
		return "redirect:/list";
	}
}
