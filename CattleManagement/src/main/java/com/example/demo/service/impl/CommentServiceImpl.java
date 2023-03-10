package com.example.demo.service.impl;

import com.example.demo.model.NewsComment;
import com.example.demo.repository.CommentRepo;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Override
    public NewsComment findNewsCommentByCommentId(Long newsCommentId) {
        return commentRepo.findNewsCommentByCommentId(newsCommentId);
    }

    @Override
    public NewsComment save(NewsComment NewsComment) {
        return commentRepo.save(NewsComment);
    }
}
