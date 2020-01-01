package com.albert.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {
	
	@GetMapping("/systems")
	public String showAccessDenied() {
		
		return "systems/systems";
		
	}

}
