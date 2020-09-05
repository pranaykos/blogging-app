package com.blogapp.BlogApp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.blogapp.BlogApp.authService.AuthrizeUser;
import com.blogapp.BlogApp.entity.Post;
import com.blogapp.BlogApp.entity.User;
import com.blogapp.BlogApp.reposotiry.PostRepository;
import com.blogapp.BlogApp.reposotiry.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void addNewPost(Post post) {
		
		
		String loggedUsername = null;;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   AuthrizeUser userPrincipal = (AuthrizeUser)authentication.getPrincipal();
		   
		    loggedUsername = userPrincipal.getUsername();
		   
		   /*System.out.println("Username =" + userPrincipal.getUsername());
		   System.out.println("Password = " + userPrincipal.getPassword());
		   System.out.println("Authorities = " + userPrincipal.getAuthorities());
		   System.out.println("Is user enabled =" + userPrincipal.isEnabled());*/
		}
		
		User user = userService.getUserByUsername(loggedUsername);
		post.setCreatedBy(user);
		post.setCreatedByUser(user.getUsername());
		postRepository.save(post);
	}

	@Override
	public Post getPostById(int id) {
		Optional<Post> result =  postRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;	
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public List<Post> getPostsByUsername(String username) {
//		return postRepository.findByCreatedByUser(username);
		return postRepository.findByCreatedByUserOrderByPostedOnDesc(username);
	}
}
