package com.example.demo.repository;

import com.example.demo.model.News;
import com.example.demo.model.NewsComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<NewsComment, String> {
    NewsComment findNewsCommentByCommentId(Long newsCommentId);
}
