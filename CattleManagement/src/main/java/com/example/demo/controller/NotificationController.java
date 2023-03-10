package com.example.demo.controller;

import com.example.demo.model.Entities;
import com.example.demo.model.Notification;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/public/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("")
    public ResponseEntity<Page<Notification>> findAllNotification(@PageableDefault(size = 2) Pageable pageable) {
        Page<Notification> notifications = notificationService.findAll(pageable);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        return new ResponseEntity<>(entities,HttpStatus.OK);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEntities(@Valid @RequestBody Notification notification, BindingResult bindingResult) throws Exception {
//        System.out.println(entities.toString() + "vo controller");
        System.out.println(bindingResult.toString());
        System.out.println(notification.toString());
        notification.setDelete(false);

        if (bindingResult.hasErrors()) {

            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        } else {
            System.out.println("tao moi thanh cong" + notification.toString());
//            notificationService.updateAutoRender(entities.getCageId());
            notification.setDelete(false);
            return new ResponseEntity<>(notificationService.save(notification), HttpStatus.CREATED);
        }
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Notification> findNotificationById(@PathVariable int id) {
        Optional<Notification> notification = notificationService.findById(id);
        if (!notification.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(notification.get(), HttpStatus.OK);
    }
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Notification> deleteEntities(@PathVariable int id) {
        notificationService.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/update/{id}")
    public ResponseEntity<Notification> findNotificationByIdToUpdate(@PathVariable int id) {
        Optional<Notification> notificationOptional = notificationService.findById(id);
        if (!notificationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(notificationOptional.get(), HttpStatus.OK);
        }

    }
    @PatchMapping(value = "/update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Notification> updateNotification(@PathVariable int id, @RequestBody Notification notification) {
        Optional<Notification> notificationOptional  = notificationService.findById(id);
        if (!notificationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        notification.setDelete(false);

        return new ResponseEntity<>(notificationService.save(notification), HttpStatus.OK);
    }
}
