package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
	@GetMapping("/hasToBelandingPage")
	public String viewHomePage() {
		return "main/index";
	}

}
