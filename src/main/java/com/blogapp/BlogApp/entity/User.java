package com.blogapp.BlogApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.blogapp.BlogApp.validation.MatchField;


@Entity
@Table(name="users")
/*@MatchField(firstFieldName = "password", 
			secondFieldName="confirmPassword", 
			message="Password and confirm Password did not matched")*/
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobileNo")
	private String mobileNo;
	
	@OneToMany(mappedBy="createdBy", cascade=CascadeType.ALL)
//	@OneToMany(mappedBy="createdBy")
	private List<Post> posts;
	
	@Column(name="role")
	private String role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(int id, String name, String username, String password, String email, String mobileNo, List<Post> posts,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.posts = posts;
		this.role = role;
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
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", email="
				+ email + ", mobileNo=" + mobileNo + ", role=" + role + "]";
	}
	
	
	
	
}
