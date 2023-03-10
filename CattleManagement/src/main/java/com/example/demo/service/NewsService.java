package com.example.demo.service;

import com.example.demo.model.News;
import com.example.demo.model.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewsService {
    Page<News> findAll(Pageable pageable);
    Page<News> findAllByNewsNameContaining(String name, Pageable pageable);
    Page<News> findAllByNewsNameContainingDate(String name, Pageable pageable);
    Page<News> findAllByNewsNameContainingDateAsc(String name, Pageable pageable);
    Page<News> findAllByNewsNameContainingTotalViews(String name, Pageable pageable);
    Page<News> findAllByHighlight(String name, Pageable pageable);
    Page<News> findAllByTotalView(Pageable pageable);
    News findNewsByNewsId(Long newsId);
    News save(News news);
    Page<statisticalTypeNewsDTO> statisticalTotalViewsByType(Pageable pageable);
    Page<CommentNewsDTO> findNewsByNewsComments(String id, Pageable pageable);
    UserCommentDTO findUser(String idAccount);
    void createComment(CommentCreateDTO commentCreateDTO);
}