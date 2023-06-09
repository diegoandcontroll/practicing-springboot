package com.diegoandcontroll.dslearnbds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diegoandcontroll.dslearnbds.dto.NotificationDTO;
import com.diegoandcontroll.dslearnbds.services.NotificationService;



@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

	@Autowired
	private NotificationService service;

	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(
			@RequestParam(value = "unreadOnly", defaultValue = "false") Boolean unreadOnly, 
			Pageable pageable) {
		return ResponseEntity.ok().body(service.notificationForCurrentUser(unreadOnly,pageable));
	}

}
