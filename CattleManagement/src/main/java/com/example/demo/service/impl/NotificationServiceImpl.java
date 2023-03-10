package com.example.demo.service.impl;

import com.example.demo.model.Notification;
import com.example.demo.repository.NotificationRepo;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;
    @Override
    public Page<Notification> findAll(Pageable pageable) {
        return notificationRepo.findAll(pageable);
    }

    @Override
    public Optional<Notification> findById(int id) {
        return notificationRepo.findByNotificationId(id);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public void deleteNotification(int id) {
        notificationRepo.deleteNotification(id);
    }

    @Override
    public Integer getNotificationId(int notificationId) {
        return null;
    }
}
