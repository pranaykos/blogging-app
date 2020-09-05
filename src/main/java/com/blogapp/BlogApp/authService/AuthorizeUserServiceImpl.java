package com.blogapp.BlogApp.authService;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogapp.BlogApp.authority.Role;
import com.blogapp.BlogApp.entity.User;
import com.blogapp.BlogApp.reposotiry.UserRepository;

@Service
public class AuthorizeUserServiceImpl implements AuthorizeUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username or Password");
		}
//		System.out.println("fetched user : "+user);
		return getUserDetails(user);
	}

	private AuthrizeUser getUserDetails(User user) {
		Set<SimpleGrantedAuthority> authorities = getAuthorities(user.getRole());
		return new AuthrizeUser(authorities, 
								user.getUsername(), 
								user.getPassword(), 
								true, 
								true, 
								true, 
								true);
	}

	private Set<SimpleGrantedAuthority> getAuthorities(String role) {
		System.out.println("Request for Role |"+role+"|");
		
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		switch(role) {
			case "USER" : 
				authorities = Role.USER.getGrantedAuthority();
				System.out.println("Inside Case User");
				System.out.println("Granted Permissions ");
				System.out.println("Authorities : "+authorities);
				break;
				
			case "ADMIN" : 
				authorities = Role.ADMIN.getGrantedAuthority();
				System.out.println("Inside Case Admin");
				System.out.println("Granted Permissions ");
				System.out.println("Authorities : "+authorities);
				break;
				
			default : 
				System.out.println("Nothing matched");
		}
		
		return authorities;
	}

}
