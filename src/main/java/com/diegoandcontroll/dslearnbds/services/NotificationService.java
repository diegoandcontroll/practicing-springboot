package com.diegoandcontroll.dslearnbds.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diegoandcontroll.dslearnbds.domain.Notification;
import com.diegoandcontroll.dslearnbds.domain.User;
import com.diegoandcontroll.dslearnbds.dto.NotificationDTO;
import com.diegoandcontroll.dslearnbds.repositories.NotificationRepository;



@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationForCurrentUser(boolean unreadOnly,Pageable pageable) {
		// Busquei o usuario autenticado
		User user = authService.authenticated();
		// Fazemos agora a busca somente das notificações do  usuario autenticado
		Page<Notification> page = notificationRepository.find(user,unreadOnly, pageable);
		return page.map(x -> new NotificationDTO(x));
	}
}
