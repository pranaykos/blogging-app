package com.blogapp.BlogApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/loginForm")
	public String showLoginForm() {
		return "login-form";
	}
}