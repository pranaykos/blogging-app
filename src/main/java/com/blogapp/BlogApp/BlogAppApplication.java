package com.blogapp.BlogApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.blogapp.BlogApp.entity.Comment;
import com.blogapp.BlogApp.entity.Post;
import com.blogapp.BlogApp.entity.User;
import com.blogapp.BlogApp.reposotiry.CommentRepository;
import com.blogapp.BlogApp.reposotiry.PostRepository;
import com.blogapp.BlogApp.reposotiry.UserRepository;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
					SpringApplication.run(BlogAppApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		PostRepository postRepository = context.getBean(PostRepository.class);
		CommentRepository commentRepository = context.getBean(CommentRepository.class);
		
		
		
		
		
		
	/*	
		
//		Comments
		Comment comment1 = new Comment();
		Comment comment2 = new Comment();
			
		comment1.setComent("very noce post");
		comment1.setCommentedBy("username1");
		
		
		comment2.setComent("very bad post");
		comment2.setCommentedBy("username2");
		
		
//		Posts
		Post post1 = new Post();
		post1.setTitle("post title");
		post1.setBody("post content goes here");
		
		
//		User
		User user = new User();
		user.setName("my name");
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("email");
		user.setMobileNo("79759834985");
		
		
//		Joining
		
//		Comments joining
		comment1.setPost(post1);
		comment2.setPost(post1);
		
//		Post Joining
		List<Comment> comments = new ArrayList<Comment>();
		
		comments.add(comment1);
		comments.add(comment2);
		
		post1.setComments(comments);
		
		post1.setCreatedBy(user);
		
//		User Joining
		List<Post> posts = new ArrayList<>();
		posts.add(post1);
		user.setPosts(posts);
		
		
		userRepository.save(user);
		*/
		
		
		/*userRepository.deleteById(1);*/
		
	}

}
