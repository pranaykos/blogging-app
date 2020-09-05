package com.blogapp.BlogApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogapp.BlogApp.authService.AuthrizeUser;
import com.blogapp.BlogApp.entity.Post;
import com.blogapp.BlogApp.entity.User;
import com.blogapp.BlogApp.pojos.FormUser;
import com.blogapp.BlogApp.service.PostService;
import com.blogapp.BlogApp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new FormUser());
		return "register-page";
	}
	
	@PostMapping("/register")
	public String addNewUser(@Valid @ModelAttribute("user") FormUser user,
							BindingResult result) {
		
		System.out.println("Inside UserController "+user);
		
		if(result.hasErrors()) {
			System.out.println("Error happened");
			return "register-page";
		}
		
		System.out.println("New User added");
		userService.addNewUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/profile/{profileName}")
	public String profileDetails(@PathVariable("profileName") String profileName,
								Model model) {
		
		
		String loggedUsername = null;
		boolean isSameUser = false;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   AuthrizeUser userPrincipal = (AuthrizeUser)authentication.getPrincipal();
		   
		    loggedUsername = userPrincipal.getUsername();
		}
		isSameUser = loggedUsername.equals(profileName);
		
		User user = userService.getUserByUsername(profileName);
		model.addAttribute("user", user);
		model.addAttribute("loggedUsername", loggedUsername);
		model.addAttribute("isOwner", isSameUser);
		model.addAttribute("profileName", profileName);
		
		model.addAttribute("posts", postService.getPostsByUsername(profileName));
		
		return "profile-dashboard";
	}
	
}
