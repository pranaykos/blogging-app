package com.blogapp.BlogApp.reposotiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.BlogApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
