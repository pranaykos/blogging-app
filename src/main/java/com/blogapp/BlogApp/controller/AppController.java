package com.blogapp.BlogApp.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blogapp.BlogApp.authService.AuthrizeUser;
import com.blogapp.BlogApp.entity.Post;
import com.blogapp.BlogApp.service.PostService;

@Controller
public class AppController {
	
	
	@Autowired
	private PostService postService;

	
	@GetMapping("/")
	public String showPage(Model model, HttpSession session) {
		
		List<Post> posts = postService.getAllPosts();
		model.addAttribute("posts", posts);
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   AuthrizeUser userPrincipal = (AuthrizeUser)authentication.getPrincipal();
		   
		   session.setAttribute("username", userPrincipal.getUsername());
		   session.setAttribute("isLoggedIn", true);
		   
		   /*System.out.println("Username =" + userPrincipal.getUsername());
		   System.out.println("Password = " + userPrincipal.getPassword());
		   System.out.println("Authorities = " + userPrincipal.getAuthorities());
		   System.out.println("Is user enabled =" + userPrincipal.isEnabled());*/
		}
		
		
		return "feedspage";
	}
}
