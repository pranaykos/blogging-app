package com.blogapp.BlogApp.reposotiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.BlogApp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	public List<Post> findByCreatedByUserOrderByPostedOnDesc(String username);
}
