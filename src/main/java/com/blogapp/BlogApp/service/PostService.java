package com.blogapp.BlogApp.service;

import java.util.List;

import com.blogapp.BlogApp.entity.Post;

public interface PostService {
	
	public void addNewPost(Post post);
	public Post getPostById(int id);
	public List<Post> getAllPosts();
	public List<Post> getPostsByUsername(String username);
}
