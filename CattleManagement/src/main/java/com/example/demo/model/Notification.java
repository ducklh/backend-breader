package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
//    @Column(columnDefinition = "int",nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;



    @Column(columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "{Content can't be blank}")
    @Length(min = 30,max = 1500,message = "Độ dài sai")
    private String content;

    @Column(columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "{Image can't be blank}")
    private String image;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate;

    private Boolean isDelete;

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", uploadDate=" + uploadDate +
                ", isDelete=" + isDelete +
                '}';
    }
}
