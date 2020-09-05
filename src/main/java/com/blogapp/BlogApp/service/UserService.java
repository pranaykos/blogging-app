package com.blogapp.BlogApp.service;

import com.blogapp.BlogApp.entity.User;
import com.blogapp.BlogApp.pojos.FormUser;

public interface UserService {
	public void addNewUser(FormUser formUser);
	public User getUserById(int userId);
	public User getUserByUsername(String username);}
