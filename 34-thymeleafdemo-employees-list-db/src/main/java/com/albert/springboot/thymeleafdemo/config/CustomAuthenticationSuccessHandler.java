package com.albert.springboot.thymeleafdemo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.albert.springboot.thymeleafdemo.entity.User;
import com.albert.springboot.thymeleafdemo.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
		implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

		String userName = authentication.getName();

		System.out.println("userName=" + userName);

		User theUser = userService.findByUserName(userName);

		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);

		// forward to home page

//		response.sendRedirect(request.getContextPath() + "/");

		
		// get previous page
		String redirectUrl = (String) session.getAttribute("url_prior_login");
		if (redirectUrl != null) {
			// we do not forget to clean this attribute from session
			session.removeAttribute("url_prior_login");
			// then we redirect
			getRedirectStrategy().sendRedirect(request, response, redirectUrl);
		} else {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}


}
