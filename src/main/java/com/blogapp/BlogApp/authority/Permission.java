package com.blogapp.BlogApp.authority;

public enum Permission {
	
	CREATE_USER("creat:user"),
	DELETE_USER("delete:user"),
	ACTIVATE_ACCOUNT("activate:acccount"),
	DEACTIVATE_ACCOUNT("deactivate:account");
	
	private final String permission; 
	
	private Permission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return this.permission;
	}
}
