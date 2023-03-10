package com.example.demo.service;

import com.example.demo.model.Entities;
import com.example.demo.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NotificationService extends IGeneralNotificationService<Notification> {
    Page<Notification> findAll(Pageable pageable);
    Optional<Notification> findById(int id);
    Notification save(Notification notification);
    void deleteNotification(int id);
//    Page<Entities> findAllByInDateAndCage22(Pageable pageable,String inDate,String cage);
//    Page<Entities> findAllByInDateAndCage3(Pageable pageable,String inDateMin,String inDateMax,String cage);
    Integer getNotificationId(int notificationId);
}
