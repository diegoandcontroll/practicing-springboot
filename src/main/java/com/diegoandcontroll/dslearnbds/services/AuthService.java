package com.diegoandcontroll.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diegoandcontroll.dslearnbds.domain.User;
import com.diegoandcontroll.dslearnbds.repositories.UserRepository;
import com.diegoandcontroll.dslearnbds.services.exceptions.ForbiddenException;
import com.diegoandcontroll.dslearnbds.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * Método para pegar o usuário atual (autenticado)
	 * 
	 * Exemplo : Requisição pro backend com o Token JWT , o Spring Security
	 * reconhece o usuario , como que vai pegar ele ?
	 * 
	 * 
	 */
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}

	}

	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		if (user.getId() != userId && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Acess denied");
		}
	}

}
