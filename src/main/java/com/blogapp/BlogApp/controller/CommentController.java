package com.blogapp.BlogApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogapp.BlogApp.entity.Comment;
import com.blogapp.BlogApp.entity.Post;
import com.blogapp.BlogApp.reposotiry.CommentRepository;
import com.blogapp.BlogApp.service.PostService;

@Controller
@RequestMapping("/user/posts/{postId}/comments")
public class CommentController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@PostMapping("")
	public String addComent(@ModelAttribute("comment") Comment comment,
							@PathVariable("postId") int postId) {
		
		
		Post post = postService.getPostById(postId);
		
		comment.setCommentedBy("pranay");
		comment.setPost(post);
		commentRepository.save(comment);
		
		return "redirect:/user/posts/"+postId;
	}
}
