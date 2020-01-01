package com.albert.springboot.thymeleafdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

//	@GetMapping("/showMyLoginPage")
//	public String showMyLoginPage() {
//		return "landing";
//	}
	
	// get previous page (Referer)
	@RequestMapping(value = "/showMyLoginPage", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {
	    String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("url_prior_login", referrer);
	    // can try another landing make every thing sure
	    return "landing";
	}
	
	// add request mapping for /access-denied
	// I want to do just pop out denied message not turn to another html
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "login/access-denied";
		
	}
	
}