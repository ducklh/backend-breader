package com.example.demo.service;

import com.example.demo.model.NewsComment;

public interface CommentService {
    NewsComment findNewsCommentByCommentId(Long newsCommentId);
    NewsComment save(NewsComment NewsComment);
}
