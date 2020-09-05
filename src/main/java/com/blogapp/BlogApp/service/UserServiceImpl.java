package com.blogapp.BlogApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapp.BlogApp.entity.User;
import com.blogapp.BlogApp.pojos.FormUser;
import com.blogapp.BlogApp.reposotiry.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void addNewUser(FormUser formUser) {
		
		User user = new User();
		user.setRole("USER");
		
		user.setName(formUser.getName());
		user.setUsername(formUser.getUsername());
		user.setEmail(formUser.getEmail());
		user.setMobileNo(formUser.getMobileNo());
		
		String plenePassword = formUser.getPassword();
		
		user.setPassword(encoder.encode(plenePassword));
		
		userRepository.save(user);
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> result = userRepository.findById(userId);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	

}
