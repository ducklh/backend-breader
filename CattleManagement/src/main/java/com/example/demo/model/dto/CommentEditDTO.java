package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CommentEditDTO {
    Long commentId;
    String content;
    String newsId;
    String employeeId;
    Boolean isDelete;

    public CommentEditDTO(String content, String newsId, String employeeId, Boolean isDelete) {
        this.content = content;
        this.newsId = newsId;
        this.employeeId = employeeId;
        this.isDelete = isDelete;
    }

    public CommentEditDTO(Long commentId, String content, String newsId, String employeeId, Boolean isDelete) {
        this.commentId = commentId;
        this.content = content;
        this.newsId = newsId;
        this.employeeId = employeeId;
        this.isDelete = isDelete;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
