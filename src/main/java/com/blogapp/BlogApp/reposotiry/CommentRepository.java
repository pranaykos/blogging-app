package com.blogapp.BlogApp.reposotiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.BlogApp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
