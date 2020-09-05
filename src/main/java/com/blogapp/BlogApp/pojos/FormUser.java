package com.blogapp.BlogApp.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blogapp.BlogApp.validation.MatchField;



@MatchField(firstFieldName="password", 
			secondFieldName="confirmPassword", 
			message="Password and Confirm password should be same")
public class FormUser {

	private int id;

	@NotNull(message="Name cant be Null")
	@Size(min=1, message="Name is Required")
	private String name;
	
	@NotNull(message="Username cant be Null")
	@Size(min=1, message="Username is Required")
	private String username;
	
	@NotNull(message="Password cant be Null")
	@Size(min=1, message="Password is Required")
	private String password;
	
	@NotNull(message="confirmPassword No cant be Null")
	@Size(min=1, message="confirmPassword is Required")
	private String confirmPassword;
	
	@NotNull(message="Email cant be Null")
	@Size(min=1, message="Email is Required")
	private String email;
	
	private String mobileNo;
	

	public FormUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FormUser(int id, String name, String username, String password, String confirmPassword, String email,
			String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.mobileNo = mobileNo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	@Override
	public String toString() {
		return "FormUser [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
}
