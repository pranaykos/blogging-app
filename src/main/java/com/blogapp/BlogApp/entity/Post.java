package com.blogapp.BlogApp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "body")
	private String body;

	@Column(name = "postedOn")
	private Date postedOn;;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User createdBy;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@Column(name="user_name")
	private String createdByUser;

	public Post() {
		super();
		this.postedOn = new Date();
	}
	

	public Post(int id, String title, String body, Date postedOn, User createdBy, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.postedOn = new Date();
		this.createdBy = createdBy;
		this.comments = comments;
		this.createdByUser = null;
	}
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", postedOn=" + postedOn + ", createdBy="
				+ createdBy + ", createdByUser=" + createdByUser + "]";
	}
	
	

	
	 
	 

}
