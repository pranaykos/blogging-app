package com.blogapp.BlogApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="coment")
	private String coment;
	
	@ManyToOne
	@JoinColumn(name = "post_id" , nullable = false)
	private Post post;
	
	@Column(name="commentedby")
	private String commentedBy;
	
	@Column(name="commenton")
	private Date commentOn;
	
	public Comment() {
		super();
		this.commentOn = new Date();
	}


	
	
	public Comment(int id, String coment, Post post, String commentedBy, Date commentOn) {
		super();
		this.id = id;
		this.coment = coment;
		this.post = post;
		this.commentedBy = commentedBy;
		this.commentOn = new Date();
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}
	
	
	
	public Date getCommentOn() {
		return commentOn;
	}




	public void setCommentOn(Date commentOn) {
		this.commentOn = commentOn;
	}




	@Override
	public String toString() {
		return "Comment [id=" + id + ", coment=" + coment + ", post=" + post + ", commentedBy=" + commentedBy
				+ ", commentOn=" + commentOn + "]";
	}



	
	
}
