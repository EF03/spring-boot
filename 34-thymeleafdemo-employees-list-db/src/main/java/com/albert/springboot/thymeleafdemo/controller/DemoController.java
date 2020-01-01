package com.albert.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/index")
	public String showLanding(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "landing";
	}

}
