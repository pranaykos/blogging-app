package com.blogapp.BlogApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogapp.BlogApp.authService.AuthrizeUser;
import com.blogapp.BlogApp.entity.Comment;
import com.blogapp.BlogApp.entity.Post;
import com.blogapp.BlogApp.entity.User;
import com.blogapp.BlogApp.reposotiry.PostRepository;
import com.blogapp.BlogApp.service.PostService;
import com.blogapp.BlogApp.service.UserService;

@Controller
@RequestMapping("/user/posts")
public class PostController {

	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/new")
	public String addNewPostForm(Model model) {
		model.addAttribute("post", new Post());
		return "new-post-form";
	}
	
	@PostMapping("/addPost")
	public String addNewPost(@ModelAttribute("post") Post post) {
		
		String loggedUsername = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   AuthrizeUser userPrincipal = (AuthrizeUser)authentication.getPrincipal();
		   
		    loggedUsername = userPrincipal.getUsername();
		}
		
		User user = userService.getUserByUsername(loggedUsername);
		post.setCreatedBy(user);
		postService.addNewPost(post);
		
		return "redirect:/user/profile/"+loggedUsername;
	}
	
	@GetMapping("/delete")
	public String deletePost(@RequestParam("postId") int postId,
								HttpSession session) {

		if(((Object)postId) instanceof Integer) {
			Post post = postService.getPostById(postId);
			if(post != null && session.getAttribute("username").equals(post.getCreatedByUser())) {
				System.out.println("DELETE REquest for post"+postId);
				postService.deletePostById(postId);
				System.out.println("post deleted "+postId);
			}
		}
		
//		return "redirect:/user/posts/"+postId;
		return "redirect:/";
	}
	
	@GetMapping("/{postId}")
	public String showPostForId(@PathVariable("postId") int postId,
								Model model, 
								HttpSession session) {
		
		Post post = postService.getPostById(postId);
		
		List<Comment> comments = post.getComments();
		boolean isSameUser = session.getAttribute("username").equals(post.getCreatedByUser());
		
		/*System.out.println("logged User : "+session.getAttribute("username"));
		System.out.println("Comment Owner :"+post.getCreatedByUser());*/
		
//		comments.forEach(comment -> System.out.println(comment));
		
		model.addAttribute("post", post);
		model.addAttribute("newComment", new Comment());
		model.addAttribute("comments", comments);
		model.addAttribute("isSameUser", isSameUser);
		
//		System.out.println("Is same user :"+isSameUser);
		
		return "show-post";
	}
	
}
