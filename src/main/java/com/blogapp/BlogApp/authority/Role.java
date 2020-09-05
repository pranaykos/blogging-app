package com.blogapp.BlogApp.authority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
	USER(com.google.common.collect.Sets.newHashSet(
				Permission.CREATE_USER
			)),
	ADMIN(com.google.common.collect.Sets.newHashSet(
			Permission.CREATE_USER,
			Permission.DELETE_USER,
			Permission.ACTIVATE_ACCOUNT,
			Permission.DEACTIVATE_ACCOUNT
		));
	
	
	private Set<Permission> permissions;

	private Role(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	private Set<Permission> getPermission(){
		return this.permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthority(){
		Set<SimpleGrantedAuthority> authorities = 
				getPermission().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
						.collect(Collectors.toSet());
			authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return authorities;
	}
	
}
